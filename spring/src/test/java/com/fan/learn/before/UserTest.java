/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 13:47
 */
package com.fan.learn.before;

import com.fan.learn.before.domain.User;
import com.fan.learn.before.service.UserService;
import com.fan.learn.before.service.UserServiceImpl;
import org.junit.Test;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class UserTest {
    @Test
    public void test0(){
        UserService userService = new UserServiceImpl();

        User user = new User();
        user.setId(1);
        user.setName("fan");

        userService.add(user);
    }

}
