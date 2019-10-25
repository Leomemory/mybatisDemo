package com.zpc.mybatis.dao;

import com.zpc.mybatis.dao.impl.UserDaoImpl;
import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*
* UserDao的测试用例
* */

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
//        this.userDao = new UserDaoImpl(sqlSession);

        this.userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void queryUserById() throws Exception {
        System.out.println(this.userDao.queryUserById("1"));
    }

    @Test
    public void queryUserAll() throws Exception{
        List<User> userList = this.userDao.queryUserAll();
        for (User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setId("6");
        user.setAge(34);
        user.setBirthday(new Date("1995/09/16"));
        user.setName("乔峰");
        user.setPassword("532637");
        user.setSex(1);
        user.setUserName("qf");
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() throws Exception{
        User user = new User();
        user.setBirthday(new Date("1987/07/09"));
        user.setName("岳林珊");
        user.setPassword("937593");
        user.setSex(0);
        user.setUserName("yls");
        user.setId("2");
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() throws Exception{
        this.userDao.deleteUser("7");
        this.sqlSession.commit();
    }
}