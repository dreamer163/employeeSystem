package com.situ.servlet;

import com.situ.global.Global;
import com.situ.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(Global.USER_LOGIN_KEY);

        if (user != null) {
            req.setAttribute("user", user);

        }
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
