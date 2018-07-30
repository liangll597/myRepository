package com.pandawork.common.entity.person;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author:lianglllianglili
 * @Description: person实体
 * @Date: 15:39 2018/7/28
 */
@Table(name = "t_person")
@Entity
public class Person extends AbstractEntity{
    //personID
    @Id
    private Integer id;

    //person姓名
    @Column(name = "name")
    private String name;

    //person年龄
    @Column(name = "age")
    private Integer age;

    //person性别
    @Column(name = "sex")
    private String sex;

    //get和set方法
    public int getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 需要把toString()方法重写。
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
