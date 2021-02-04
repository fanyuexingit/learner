/**
 * @description:
 * @author: Andy
 * @time: 2021/02/04 9:45
 */
package com.fan.learn;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanyuexin on 2021/02/04
 */
public class HelloAction implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jsp/hello.jsp");
        return modelAndView;
    }
}
