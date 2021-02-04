/**
 * @description:
 * @author: Andy
 * @time: 2021/02/04 13:25
 */
package com.fan.learn;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fanyuexin on 2021/02/04
 */
@Controller
public class HelloController {
    /**
     *  也可以加参数 HttpServletRequest request,HttpServletResponse response
     * @RequestMapping 表示只要是/hello的请求，就交由该方法处理。
     * @param model 它和ModelAndView类似，它这个Model就是把数据封装到request对象中，我们就可以获取出来
     * @return 返回跳转的页面【真实路径，就不用配置视图解析器了】
     * @throws Exception
     */
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("message","你好");
        return "/index.jsp";
//        return "redirect:/index.jsp";
//        return "redirect:/bye.action";

    }

    @RequestMapping(value = "/hello2")
    @ResponseBody
    public User hello2(@RequestBody User user){
        user.setName("fanyuexin");
        return user;
    }

    /**
     * 接受参数为日期字符串的时候，转换为Date类型
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
