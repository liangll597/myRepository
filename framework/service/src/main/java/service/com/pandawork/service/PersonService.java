package com.pandawork.service;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * @Author:liangll
 * @Description: PersonService层
 * @Date: 19:06 2018/7/28
 */
public interface PersonService {

    /**
     * person信息列表
     * @return
     * @throws SSException
     */
    public List<Person> listAllPerson() throws SSException;

    /**
     * 增加person信息
     * @throws SSException
     */
    public boolean addPerson(Person person)throws SSException;

    /**
     * 删除person信息
     * @throws SSException
     */
     public boolean delPerson(int id) throws SSException;

    /**
     * 修改person信息
     * @throws SSException
     */
     public boolean updatePerson(Person person) throws SSException;

    /**
     * 查找（根据id）
     * @throws SSException
     */
     public Person selectById(int id) throws SSException;

    /**
     * 模糊查询
     * @throws SSException
     */
     public List<Person> select(String keyword) throws SSException;
}
