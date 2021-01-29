/**
 * @description:
 * @author: Andy
 * @time: 2021/01/29 15:33
 */
package com.fan.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by fanyuexin on 2021/01/29
 */
public class ServletTest implements Servlet {
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("asdfasdfasdf");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
