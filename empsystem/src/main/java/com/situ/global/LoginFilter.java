package com.situ.global;

import com.situ.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class LoginFilter implements Filter {
    private static final List<String> whiteList = List.of("/user/login","/user/captcha", "/user/logout","/user/edit");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Global.USER_LOGIN_KEY);

        String uri = req.getRequestURI();
        System.out.println(uri);
        String ctx = req.getContextPath();//上下文路径
        String action = uri.replace(ctx, "");


        boolean match = false;
        if (uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg")) {
            match = true;
        } else {
            for (String url : whiteList) {
                if (action.startsWith(url)) {
                    match = true;
                    break;
                }
            }
        }

        if (match) {
            filterChain.doFilter(req, resp);
        } else {
            if (user == null) {//没有登录过，或者会话失效
                resp.sendRedirect(req.getContextPath() + "/user/login");
            } else {
                filterChain.doFilter(req, resp);
            }
        }
    }
}
