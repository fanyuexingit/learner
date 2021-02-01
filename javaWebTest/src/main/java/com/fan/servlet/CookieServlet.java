/**
 * @description:
 * @author: Andy
 * @time: 2021/02/01 15:20
 */
package com.fan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by fanyuexin on 2021/02/01
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i <= cookies.length; i++){
            String name = cookies[i].getName();
            String value = URLDecoder.decode(cookies[i].getValue(), "utf-8");
            resp.getWriter().write(name + " : " + value);
        }


        resp.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("username", URLEncoder.encode("fanyuexin", "utf-8"));
        cookie.setMaxAge(60 * 30);
        resp.addCookie(cookie);
        resp.getWriter().write("我发送了一个cookie");

    }
}
