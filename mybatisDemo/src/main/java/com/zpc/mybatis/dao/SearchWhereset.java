package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchWhereset {
    /*
    * * 查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立
     * @param name
     * @param age*/
    public List<User> queryUserListByNameAndAge(@Param("name") String name, @Param("age") Integer age);
}
