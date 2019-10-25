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

public class SearchWheresetTest {
    public SearchWhereset searchWhereset;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.searchWhereset = sqlSession.getMapper(SearchWhereset.class);
    }

    @Test
    public void queryUserListByNameAndAge() {
        List<User> users = this.searchWhereset.queryUserListByNameAndAge("令狐冲", 28);
        for (User user : users) {
            System.out.println(user);
        }
    }
}