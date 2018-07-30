package com.pandawork.service;

import com.pandawork.common.entity.users.Users;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * @Author:liangll
 * @Description: UsersService层
 * @Date: 19:07 2018/7/28
 */
public interface UsersService {

    /**
     * 登录
     * @param username
     * @return
     * @throws SSException
     */
    public Users selectByName(String username) throws SSException;

    /**
     * 注册
     * @param users
     * @return
     * @throws SSException
     */
    public  boolean register(Users users) throws SSException;
}
