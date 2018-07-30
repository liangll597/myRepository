package com.pandawork.service.impl;

import com.pandawork.common.entity.users.Users;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.users.UsersMapper;
import com.pandawork.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:liangll
 * @Description:
 * @Date: 10:52 2018/7/29
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public Users selectByName(String username) throws SSException {
        if (Assert.isNull(username)) {
            return null;
        }
        try {
            return usersMapper.selectByName(username);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SelectNameFailed, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean register(Users users) throws SSException {
        if (Assert.isNull(users)){
            return false;
        }
        Assert.isNotNull(users.getPassword(), NFException.UserNameNotNull);
        Assert.isNotNull(users.getUsername(), NFException.PasswordNotNull);
        try {
            return usersMapper.register(users);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
