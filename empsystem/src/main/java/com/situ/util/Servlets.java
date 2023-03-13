package com.situ.util;

import com.alibaba.fastjson2.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlets {
    public static void renderJson(String str, HttpServletResponse resp) {
        //ajax响应类型
        resp.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter pw = resp.getWriter();
            pw.write(str);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renderJson(Object object, HttpServletResponse resp) {
        renderJson(JSON.toJSONString(object), resp);
    }
}
