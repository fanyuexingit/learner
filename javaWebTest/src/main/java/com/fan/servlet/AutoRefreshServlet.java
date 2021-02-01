/**
 * @description:
 * @author: Andy
 * @time: 2021/02/01 14:00
 */
package com.fan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fanyuexin on 2021/02/01
 */
public class AutoRefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("3秒后跳转页面.....");

        //三秒后跳转到index.jsp页面去，web应用的映射路径我设置成/，url没有写上应用名
        resp.setHeader("Refresh", "3;url='/javaWebTest_war_exploded/index.jsp'");
    }
}
