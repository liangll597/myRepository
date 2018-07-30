package com.pandawork.common.utils;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * NFException
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:55
 */
public enum  NFException implements IBizExceptionMes {
    SystemException("系统内部异常", 1),

    UserNameNotNull("用户名不能为空", 10001),
    PasswordNotNull("密码不能为空", 10002),
    ListPersonAll("获取person列表失败",10003),
    CountAll("获取学生信息数目失败",10004 ),
    StudentNameNotNull("获取学生姓名为空",10005 ),
    StudentNumLessOrEqualZero("学生学号小于零",10006 ),
//    SexNotNull( "获取学生性别为空",10007),
    SexNotNull( "获取person性别为空",10007),
    NameNotNull("获取person姓名为空",10018),
    AgeNotNull("获取person年龄为空",10019),
    GradeLessOrEqualZero("获取学生年级小于零",10008),
    ClassNumLessOrEqualZero("获取学生年级小于零",10009),
    CollegeNotNull("获取学生学院为空",10010),
    BirthdayNotNull("获取学生生日为空",10011),
    GoodStudentNotNull("获取是否为好学生为空",10012),
    DelPersonNull("删除person信息失败",10013),
    UpdatePersonFailed("更新person信息失败",10014),
    UpdateStudentByIdFailed("按照id查询学生信息失败",10016),
    QueryAllFailed("模糊查询person信息失败",10017 ),

    queryPersonByIdFailed("", 10017),
    SelectNameFailed("根据姓名查找失败",10020);
    private String msg;
    private Integer code;

    NFException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }


    @Override
    public String getMes() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
