package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

/*
* mybatis一对一查询*/

public interface OrderMapper {
    public OrderUser queryOrderUserByOrderNumber(@Param("number") String number);
}
