package com.situ.servlet;

import com.situ.global.Global;
import com.situ.model.Employee;
import com.situ.model.User;
import com.situ.service.UserService;
import com.situ.service.impl.UserServiceImpl;
import com.situ.util.BeanFactory;
import com.situ.util.Servlets;
import com.wf.captcha.utils.CaptchaUtil;
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

@WebServlet("/user/*")
public class LoginServlet extends HttpServlet {
    private final UserService service = BeanFactory.getBean(UserServiceImpl.class);
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");
        if (action.equals("/user/login")) {
            String error = (String) req.getSession().getAttribute("error");
            if (error != null) {
                req.setAttribute("error", error);
                req.getSession().removeAttribute("error");
            }
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        } else if (action.equals("/user/logout")) {
            //退出
            req.getSession().removeAttribute(Global.USER_LOGIN_KEY);
            //响应
            resp.sendRedirect(req.getContextPath() + "/index");
        } else if (action.equals("/user/captcha")) {
            CaptchaUtil.out(200, 40, 4, req, resp);
        } else if (action.equals("/user/edit")) {
            req.getRequestDispatcher("/WEB-INF/jsp/user/useredit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
        String uri = req.getRequestURI();
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");

        if (action.equals("/user/login")) {
            login();
        } else if (action.equals("/user/edit")) {
            editUser();
        }
    }

    private void login() throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //验证码判断
        String captcha = req.getParameter("captcha");
        //判断
        boolean b = CaptchaUtil.ver(captcha,req);

        if(!b){
            req.getSession().setAttribute("error", "验证码不正确");
            resp.sendRedirect(req.getContextPath() + "/user/login");
            return;
        }

        User user = service.findByUsername(username);
        if (user == null) {
            req.getSession().setAttribute("error", "用户名不存在");
            resp.sendRedirect(req.getContextPath() + "/user/login");
            return;
        }

        boolean passed = service.checkLogin(user, password);

        if (passed) {
            req.getSession().setAttribute(Global.USER_LOGIN_KEY, user);
            resp.sendRedirect(req.getContextPath() + "/index");
        } else {
            req.getSession().setAttribute("error", "密码不正确");
            resp.sendRedirect(req.getContextPath() + "/user/login");
        }
    }

    private void editUser() throws IOException {
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        String newpassword =req.getParameter("newpassword");
        String newpassword2 =req.getParameter("newpassword2");

        HttpSession session =req.getSession();

        boolean passed =true;

        List<String> errors =new ArrayList<>();

        User user = service.findByUsername(username);

        //校验
        if(!StringUtils.hasText(username)){
            passed=false;
            errors.add("用户名不能为空");
        }
        if(!StringUtils.hasText(password)){
            passed=false;
            errors.add("密码不能为空");
        }
        if(!StringUtils.hasText(newpassword)){
            passed=false;
            errors.add("新密码不能为空");
        }

        if (!newpassword.equals(password)){
            passed=false;
            errors.add("新旧密码不同");
        }
        if (!newpassword.equals(newpassword2)){
            passed=false;
            errors.add("两次密码输入不同");
        }

        if (user == null) {
            req.getSession().setAttribute("error", "用户名不存在");
            resp.sendRedirect(req.getContextPath() + "/user/edit");
            return;
        }

        if(!passed){
            session.setAttribute("user",user);
            String error =errors.stream().collect(Collectors.joining(","));
            session.setAttribute("error",error);
        }

        boolean passed1 = service.checkLogin(user, password);

        if (passed1) {
            req.getSession().setAttribute(Global.USER_LOGIN_KEY, user);
            user.setPassword(newpassword);
        } else {
            req.getSession().setAttribute("error", "旧密码不正确");
            resp.sendRedirect(req.getContextPath() + "/user/edit");
        }

        boolean b =service.update(user);
        if (b){
            Servlets.renderJson(Map.of("success",true),resp);
        }else {
            Servlets.renderJson(Map.of("success",false,"error","修改密码失败"),resp);
        }
    }
}
