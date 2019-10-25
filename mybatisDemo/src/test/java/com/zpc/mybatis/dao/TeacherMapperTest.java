package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherMapperTest {
    public TeacherMapper teacherMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @Test
    public void queryTeacherPositionResultMap() {
        List<Teacher> list = this.teacherMapper.queryTeacherPositionResultMap();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void queryTeacherPositionResultMapById() {
        Teacher teacher = this.teacherMapper.queryTeacherPositionResultMapById(5);
        System.out.println(teacher);
    }
}