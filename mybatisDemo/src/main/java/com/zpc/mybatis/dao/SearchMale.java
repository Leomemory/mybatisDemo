package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchMale {
    /*
    *  * 应用场景：查询男性用户，如果输入了姓名，则按姓名查询
     * @param name*/

    public List<User> queryUserList(@Param("name") String name);
}
