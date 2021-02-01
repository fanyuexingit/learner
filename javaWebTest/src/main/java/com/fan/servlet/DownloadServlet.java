/**
 * @description:
 * @author: Andy
 * @time: 2021/02/01 13:43
 */
package com.fan.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by fanyuexin on 2021/02/01
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/static/javaWeb0.png");

        FileInputStream fileInputStream = new FileInputStream(realPath);
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

//        设置消息头，告诉浏览器，我要下载
        resp.setHeader("Content-Disposition", "attachment; filename="+fileName);
//        中文
//        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));


        //把读取到的资源写给浏览器
        int len ;
        byte[] bytes = new byte[1024];
        ServletOutputStream servletOutputStream = resp.getOutputStream();

        while ((len = fileInputStream.read(bytes)) > 0) {
            servletOutputStream.write(bytes, 0, len);
        }

        servletOutputStream.close();
        fileInputStream.close();
    }
}
