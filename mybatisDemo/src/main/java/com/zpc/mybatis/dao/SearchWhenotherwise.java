package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchWhenotherwise {
    /*
    *  * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     * @param name
     * @param age*/

    List<User> queryUserListByNameOrAge(@Param("name") String name, @Param("age") Integer age);
}
