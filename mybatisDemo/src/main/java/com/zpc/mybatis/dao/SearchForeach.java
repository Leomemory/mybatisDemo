package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchForeach {
    /*
    * 按照多个id查询用户信息
    * @param ids*/
    public List<User> queryUserListByIds(@Param("ids") String[] ids);
}
