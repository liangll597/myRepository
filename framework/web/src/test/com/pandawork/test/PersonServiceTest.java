package com.pandawork.test;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:liangll
 * @Description: 测试personService
 * @Date: 13:01 2018/7/29
 */
public class PersonServiceTest extends AbstractTestCase{

    @Autowired
    PersonService personService;

    //测试查询person信息列表
    @Test
    public void testListAllPerson() throws SSException{
        System.out.print(personService.listAllPerson());
    }

    //测试增加person信息
    @Test
    public void testAddPerson() throws SSException{
        Person person = new Person();
        person.setId(666);
        person.setName("xiaocao");
        person.setAge(155);
        person.setSex("女");
        personService.addPerson(person);
        System.out.println("添加成功");
    }

    //测试删除person信息
    @Test
    public void testDelPerson() throws SSException{
        Person person = new Person();
        person.setId(668);
        personService.delPerson(person.getId());
        System.out.println("删除成功");
    }

    //测试修改person信息
    @Test
    public void testUpdate() throws SSException{
        Person person = new Person();
        person.setId(6);
        person.setName("老王");
        person.setAge(5);
        person.setSex("男");
        personService.updatePerson(person);
        System.out.println(personService.selectById(6));
        System.out.println("修改成功");
    }

    //测试根据id查询
    @Test
    public void testSelectById() throws SSException{
        Person person = new Person();
        person.setId(5);
        System.out.println(personService.selectById(5));
    }

    //测试模糊查询
    @Test
    public void testSelect() throws SSException{
        System.out.println(personService.select("李"));
    }
}
