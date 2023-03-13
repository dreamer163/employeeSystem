package com.situ.servlet;

import com.alibaba.fastjson2.JSON;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.EmployeeService;
import com.situ.service.impl.EmployeeServiceImpl;
import com.situ.util.BeanFactory;
import com.situ.util.PaginateInfo;
import com.situ.util.Servlets;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/employee/*")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeService service = BeanFactory.getBean(EmployeeServiceImpl.class);
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");

        if (action.equals("/employee/list")) {
            req.getRequestDispatcher("/WEB-INF/jsp/employee/list.jsp").forward(req, resp);

        } else if (action.equals("/employee/add")) {
            HttpSession session = req.getSession();
            Employee emp = (Employee) session.getAttribute("emps");
            String error = (String) session.getAttribute("error");

            if (emp != null) {
                req.setAttribute("emps", emp);
                session.removeAttribute("emps");
                req.setAttribute("error", error);
                session.removeAttribute("error");
            }
            req.getRequestDispatcher("/WEB-INF/jsp/employee/add.jsp").forward(req, resp);
        } else if (action.equals("/employee/edit")) {
            String empId = req.getParameter("empId");
            try {

                Employee emp = service.findByEmpId(empId);
                if (emp == null) {
                    req.setAttribute("error", "要修改的员工不存在");
                } else {
                    req.setAttribute("emps", emp);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("error", "请指定要修改的员工的编号");
            }
            req.getRequestDispatcher("/WEB-INF/jsp/employee/edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");
        if (action.equals("/employee/list")) {//列表查询
            search();//列表查询
        } else if (action.equals("/employee/delete")) {
            delete();//删除记录
        } else if (action.equals("/employee/add")) {
            add();//添加一条记录
        } else if (action.equals("/employee/edit")) {
            edit();//修改一条记录
        }
    }

    //查询
    private void search() {
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();
        String action = uri.replace(ctx, "");

        if (action.equals("/employee/list")) {
            //后端获取
            String pageNo = req.getParameter("pageNo");
            String pageSize = req.getParameter("pageSize");
            String empId = req.getParameter("empId");
            String name = req.getParameter("name");
            String sex = req.getParameter("sex");
            String nativePlace = req.getParameter("nativePlace");
            String birthdayFrom = req.getParameter("birthdayFrom");
            String birthdayTo = req.getParameter("birthdayTo");
            String depId = req.getParameter("depId");
            String hireDate = req.getParameter("hireDate");

            //数据碎片封装
            EmployeeSearchBean esb = new EmployeeSearchBean();

            //后端校验信息
            if (StringUtils.hasText(empId)) {
                esb.setEmpId(empId);
            }
            if (StringUtils.hasText(depId)) {
                esb.setDepId(depId);
            }

            if (StringUtils.hasText(name)) {
                esb.setName(name);
            }
            if (StringUtils.hasText(sex)) {
                esb.setSex(sex);
            }
            if (StringUtils.hasText(nativePlace)) {
                esb.setNativePlace(nativePlace);
            }
            if (StringUtils.hasText(birthdayFrom)) {
                LocalDate ld = null;
                try {
                    ld = LocalDate.parse(birthdayFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    esb.setBirthdayFrom(ld);
                } catch (Exception e) {
                    e.printStackTrace();
                    Servlets.renderJson(Map.of("error", "日期格式不正确"), resp);
                    return;
                }
            }

            if (StringUtils.hasText(birthdayTo)) {
                LocalDate ld = null;
                try {
                    ld = LocalDate.parse(birthdayTo, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    esb.setBirthdayTo(ld);
                } catch (Exception e) {
                    e.printStackTrace();
                    Servlets.renderJson(Map.of("error", "日期格式不正确"), resp);
                    return;
                }
            }

            if (StringUtils.hasText(hireDate)) {
                LocalDate ld = null;
                try {
                    ld = LocalDate.parse(hireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    esb.setHiredate(ld);
                } catch (Exception e) {
                    e.printStackTrace();
                    Servlets.renderJson(Map.of("error", "日期格式不正确"), resp);
                    return;
                }
            }

            //页码

            int iPageNo = 1;
            if (StringUtils.hasText(pageNo)) {
                iPageNo = Integer.parseInt(pageNo);

            }
            int iPageSize = 15;
            if (StringUtils.hasText(pageSize)) {
                iPageSize = Integer.parseInt(pageSize);
            }

            //前端ajax回调函数响应json，resp

            PaginateInfo pi = new PaginateInfo(iPageNo, iPageSize);

            List<Employee> emps = service.findAll(esb, pi);

            String json = JSON.toJSONString(Map.of("emps", emps, "pi", pi));
            Servlets.renderJson(json, resp);
        }

    }

    //删除
    private void delete() {
        String[] strEmpIds = req.getParameterValues("empIds");
        Integer[] empIds = new Integer[strEmpIds.length];
        //将字符串数组传为整数数组
        for (int i = 0; i < empIds.length; i++) {
            empIds[i] = Integer.valueOf(strEmpIds[i]);
        }
        try {
            int rows = service.deleteByIds(empIds);
            Servlets.renderJson(Map.of("success", true, "msg", "删除成功", "rows", rows), resp);
        } catch (Exception e) {
            e.printStackTrace();
            Servlets.renderJson(Map.of("success", false, "error", "删除失败"), resp);
        }
    }

    //添加
    private void add() throws IOException {
        String empId = req.getParameter("empId");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String nativePlace = req.getParameter("nativePlace");
        String birthday = req.getParameter("birthday");
        String depId = req.getParameter("depId");
        String hireDate = req.getParameter("hireDate");

        HttpSession session = req.getSession();
        //是否通过校验
        boolean passed = true;
        List<String> errors = new ArrayList<>();

        //校验
        Employee emp = new Employee();
        //1.
        if (!StringUtils.hasText(empId)) {
            passed = false;
            errors.add("员工编号不为空");
        }
        emp.setEmpId(empId);
        //2.
        if (!StringUtils.hasText(name)) {
            passed = false;
            errors.add("姓名不为空");
        }
        emp.setName(name);
        //3.
        if (!"男".equals(sex) && !"女".equals(sex)) {
            passed = false;
            errors.add("性别不正确");
        }
        emp.setSex(sex);
        //4.
        if (!StringUtils.hasText(depId)) {
            passed = false;
            errors.add("部门编号不为空");
        }
        emp.setDepId(depId);
        //5.
        try {
            LocalDate ld = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            emp.setBirthday(ld);
        } catch (Exception e) {
            passed = false;
            errors.add("日期格式不正确");
        }
        //6.
        try {
            LocalDate ld = LocalDate.parse(hireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            emp.setHiredate(ld);
        } catch (Exception e) {
            passed = false;
            errors.add("日期格式不正确");
        }
        //7.
        if (!StringUtils.hasText(nativePlace)) {
            passed = false;
            errors.add("籍贯不为空");
        }
        emp.setNativePlace(nativePlace);


        //

        if (!passed) {
            session.setAttribute("emps", emp);
            String error = errors.stream().collect(Collectors.joining(","));
            session.setAttribute("error", error);
            resp.sendRedirect(req.getContextPath() + "/employee/add");
            return;
        }

        boolean b = service.add(emp);

        if (b) {
            resp.sendRedirect(req.getContextPath() + "/employee/add");

        } else {
            session.setAttribute("emps", emp);
            session.setAttribute("error", "保存员工信息异常");
            resp.sendRedirect(req.getContextPath() + "/employee/add");
        }

    }

    //修改
    private void edit() throws IOException {
        String empId = req.getParameter("empId");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String nativePlace = req.getParameter("nativePlace");
        String birthday = req.getParameter("birthday");
        String depId = req.getParameter("depId");
        String hireDate = req.getParameter("hireDate");

        HttpSession session = req.getSession();
        //是否通过校验
        boolean passed = true;
        List<String> errors = new ArrayList<>();

        //校验
        Employee emp = service.findByEmpId(empId);
        //1.

        if (!StringUtils.hasText(empId)) {
            passed = false;
            errors.add("员工编号不为空");
        }
        //emp.setEmpId(empId);
        //2.
        if (!StringUtils.hasText(name)) {
            passed = false;
            errors.add("姓名不为空");
        }
        emp.setName(name);
        //3.
        if (!"男".equals(sex) && !"女".equals(sex)) {
            passed = false;
            errors.add("性别不正确");
        }
        emp.setSex(sex);
        //4.
        if (!StringUtils.hasText(depId)) {
            passed = false;
            errors.add("部门编号不为空");
        }
        emp.setDepId(depId);
        //5.
        try {
            LocalDate ld = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            emp.setBirthday(ld);
        } catch (Exception e) {
            passed = false;
            errors.add("日期格式不正确");
        }
        //6.
        try {
            LocalDate ld = LocalDate.parse(hireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            emp.setHiredate(ld);
        } catch (Exception e) {
            passed = false;
            errors.add("日期格式不正确");
        }
        //7.
        if (!StringUtils.hasText(nativePlace)) {
            passed = false;
            errors.add("籍贯不为空");
        }
        emp.setNativePlace(nativePlace);

        if (!passed) {
            session.setAttribute("emps", emp);
            String error = errors.stream().collect(Collectors.joining(","));
            session.setAttribute("error", error);
            resp.sendRedirect(req.getContextPath() + "/employee/edit");
            return;
        }

        boolean b = service.update(emp);

        if (b) {
            Servlets.renderJson(Map.of("success", true), resp);
        } else {
            Servlets.renderJson(Map.of("success", false, "error", "保存学生信息失败"), resp);
        }
    }
}

