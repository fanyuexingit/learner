/**
 * @description:
 * @author: Andy
 * @time: 2021/02/01 14:05
 */
package com.fan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by fanyuexin on 2021/02/01
 */
public class BanCacheServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //浏览器有三消息头设置缓存，为了兼容性！将三个消息头都设置了
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma", "no-cache");


        //这里为了看效果
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("你好啊" + new Date().toString());
    }
}
