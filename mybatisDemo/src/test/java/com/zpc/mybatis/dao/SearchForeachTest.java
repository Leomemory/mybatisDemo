package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class SearchForeachTest {
    public SearchForeach searchForeach;

    @Before
    public void setUp() throws Exception {
        //指定配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        this.searchForeach = sqlSession.getMapper(SearchForeach.class);
    }

    @Test
    public void queryUserListByIds() {
        List<User> users = this.searchForeach.queryUserListByIds(new String[]{"1","3","5"});
        for (User user : users) {
            System.out.println(user);
        }
    }
}