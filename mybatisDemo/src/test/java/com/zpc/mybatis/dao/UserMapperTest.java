package com.zpc.mybatis.dao;

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

public class UserMapperTest {
    public UserMapper userMapper;

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

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）

        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void login() {
        System.out.println(this.userMapper.login("zwj","135760"));
    }

    @Test
    public void queryUserByTableName() {
        List<User> userList = this.userMapper.queryUserByTableName("tb_user");
        for(User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println(this.userMapper.queryUserById("2"));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userMapper.queryUserAll();
        for (User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setId("7");
        user.setAge(20);
        user.setBirthday(new Date("1999/04/09"));
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("郭冬临");
        user.setPassword("34543643");
        user.setSex(0);
        user.setUserName("GUOdonglin");
        user.setId("7");
        this.userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        this.userMapper.deleteUserById("7");
    }
}