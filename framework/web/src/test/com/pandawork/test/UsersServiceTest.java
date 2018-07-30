package com.pandawork.test;

import com.pandawork.common.entity.person.Person;
import com.pandawork.common.entity.users.Users;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.PersonService;
import com.pandawork.service.UsersService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:liangll
 * @Description:
 * @Date: 15:32 2018/7/29
 */

public class UsersServiceTest extends AbstractTestCase{

    @Autowired
    UsersService usersService;

    //测试用户是否登录成功
    @Test
    public void testSelectName() throws SSException{
        Users users = new Users();
        users.setUsername("admin");
        System.out.println(usersService.selectByName("admin"));
    }

    //测试用户是否能注册
    @Test
    public void testRegister() throws SSException{
        Users users = new Users();
        users.setId(555);
        users.setUsername("hellohello");
        users.setPassword("hellohello");
        usersService.register(users);
        System.out.println("注册成功");
    }
}
