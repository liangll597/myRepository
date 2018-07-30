package com.pandawork.mapper.users;

import com.pandawork.common.entity.users.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:liangll
 * @Description: users的mapper层
 * @Date: 19:33 2018/7/28
 */
public interface UsersMapper {

    /**
     * 增加users
     * @param users
     * @throws Exception
     */
    public boolean register(@Param("users") Users users) throws Exception;

    /**
     * 登录
     * @param username
     * @return
     * @throws Exception
     */
    public Users selectByName(@Param("username") String username) throws Exception;
}
