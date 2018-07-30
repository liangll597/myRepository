package com.pandawork.mapper.person;

import com.pandawork.common.entity.person.Person;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author:liangll
 * @Description: person的mapper层
 * @Date: 18:12 2018/7/28
 */
public interface PersonMapper {

    /**
     * 查询所有person列表
     * @throws Exception
     */
    public List<Person> listAllPerson() throws Exception;

    /**
     * 增加person
     * @param person
     * @throws Exception
     */
    public boolean addPerson(@Param("person") Person person) throws Exception;

    /**
     *删除person
     * @param id
     * @throws Exception
     */
    public boolean delPerson(@Param("id") int id) throws Exception;

    /**
     * 更新person
     * @param person
     * @throws Exception
     */
    public boolean updatePerson(@Param("person") Person person) throws Exception;

    /**
     * 根据id查询信息
     * @param id
     * @returns
     * @throws Exception
     */
    public Person selectById(@Param("id") int id) throws Exception;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Person> select(@Param("keyword") String keyword) throws Exception;
}
