package com.situ.servlet;

import com.alibaba.fastjson2.JSON;
import com.mysql.cj.Session;
import com.situ.model.Dept;
import com.situ.model.DeptSearchBean;
import com.situ.model.Employee;
import com.situ.service.DeptService;
import com.situ.service.impl.DeptServiceImpl;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/department/*")
public class DeptServlet extends HttpServlet {
    private final DeptService service = BeanFactory.getBean(DeptServiceImpl.class);
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");

        if (action.equals("/department/list")) {
            req.getRequestDispatcher("/WEB-INF/jsp/department/deptlist.jsp").forward(req, resp);

        } else if (action.equals("/department/add")) {
            HttpSession session = req.getSession();
            Dept emp = (Dept) session.getAttribute("depts");
            String error = (String) session.getAttribute("error");

            if (emp != null) {
                req.setAttribute("dept", emp);
                session.removeAttribute("dept");
                req.setAttribute("error", error);
                session.removeAttribute("error");
            }
            req.getRequestDispatcher("/WEB-INF/jsp/department/adddept.jsp").forward(req, resp);
        }else if (action.equals("/department/edit")) {
            String depId = req.getParameter("depId");
            try {

                Dept dept =service.findByDepId(depId);
                if (dept == null) {
                    req.setAttribute("error", "要修改的部门不存在");
                } else {
                    req.setAttribute("dept", dept);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("error", "请指定要修改的员工的编号");
            }
            req.getRequestDispatcher("/WEB-INF/jsp/department/editdept.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");

        if (action.equals("/department/combolist")) {
            combolist();
        } else if (action.equals("/department/list")) {
            search();//查找一条记录
        } else if (action.equals("/department/delete")) {
            delete();//删除记录
        } else if (action.equals("/department/add")) {
            add();//添加一条记录
        }else if(action.equals("/department/edit")){
            edit();
        }
    }


    private void combolist() {
        List<Dept> depts = service.findAll();

        Servlets.renderJson(Map.of("success", true, "data", depts), resp);
    }

    //查找
    private void search() {
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();
        String action = uri.replace(ctx, "");

        if (action.equals("/department/list")) {
            //后端获取
            String pageNo = req.getParameter("pageNo");
            String pageSize = req.getParameter("pageSize");
            String depId = req.getParameter("depId");
            String name = req.getParameter("name");
            String leader = req.getParameter("leader");


            //数据碎片封装
            DeptSearchBean dsb = new DeptSearchBean();

            //后端校验信息
            if (StringUtils.hasText(depId)) {
                dsb.setDepId(depId);
            }

            if (StringUtils.hasText(name)) {
                dsb.setName(name);
            }
            if (StringUtils.hasText(leader)) {
                dsb.setLeader(leader);
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

            List<Dept> depts = service.findAll(dsb, pi);

            System.out.println(depts.toString());

            String json = JSON.toJSONString(Map.of("depts", depts, "pi", pi));

            Servlets.renderJson(json, resp);
        }

    }

    //删除
    private void delete() {
        String[] strDepIds = req.getParameterValues("depIds");
        Integer[] depIds = new Integer[strDepIds.length];
        //将字符串数组传为整数数组
        for (int i = 0; i < depIds.length; i++) {
            depIds[i] = Integer.valueOf(strDepIds[i]);
        }
        try {
            int rows = service.deleteByIds(depIds);
            Servlets.renderJson(Map.of("success", true, "msg", "删除成功", "rows", rows), resp);
        } catch (Exception e) {
            e.printStackTrace();
            Servlets.renderJson(Map.of("success", false, "error", "删除失败"), resp);
        }
    }

    //添加
    private void add() throws IOException {
        String depId = req.getParameter("depId");
        String name = req.getParameter("name");
        String leader = req.getParameter("leader");

        HttpSession session = req.getSession();

        //是否通过校验
        boolean passed = true;

        List<String> errors = new ArrayList<>();

        //校验
        Dept dept = new Dept();

        //1.
        if (!StringUtils.hasText(depId)) {
            passed = false;
            errors.add("部门编号不能为空");
        }
        dept.setDepId(depId);

        //2.
        if (!StringUtils.hasText(name)) {
            passed = false;
            errors.add("部门名不能为空");
        }
        dept.setName(name);

        //3.
        if (!StringUtils.hasText(leader)) {
            passed = false;
            errors.add("部门领导不能为空");
        }
        dept.setLeader(leader);


        if (!passed) {
            session.setAttribute("dept", dept);
            String error = errors.stream().collect(Collectors.joining(","));
            session.setAttribute("error", error);
            resp.sendRedirect(req.getContextPath() + "/department/add");

            return;
        }

        boolean b = service.add(dept);

        if (b) {
            resp.sendRedirect(req.getContextPath() + "/department/add");
        } else {
            session.setAttribute("dept", dept);
            session.setAttribute("error", "保存部门异常");
            resp.sendRedirect(req.getContextPath() + "/department/add");
        }
    }
    private void edit() throws IOException {

        String depId = req.getParameter("depId");
        String name =req.getParameter("name");
        String leader =req.getParameter("leader");

        HttpSession session = req.getSession();

        boolean passed =true;
        List<String> errors =new ArrayList<>();

        //校验
        Dept dept = service.findByDepId(depId);

        if(!StringUtils.hasText(depId)){
            passed =false;
            errors.add("部门编号不为空");
        }
        dept.setDepId(depId);
        if(!StringUtils.hasText(name)){
            passed =false;
            errors.add("部门名不为空");
        }
        dept.setName(name);
        if(!StringUtils.hasText(leader)){
            passed =false;
            errors.add("部门领导名不为空");
        }
        dept.setLeader(leader);

        if(!passed){
            session.setAttribute("dept",dept);
            String error = errors.stream().collect(Collectors.joining(","));
            session.setAttribute("error",error);
            resp.sendRedirect(req.getContextPath()+"/department/edit");
        }

        boolean b =service.update(dept);
        if (b){
            Servlets.renderJson(Map.of("success",true),resp);
        }else {
            Servlets.renderJson(Map.of("success",false,"error","保存部门信息失败"),resp);
        }
    }

}
