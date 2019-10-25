package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Position;
import javafx.geometry.Pos;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class PositionMapperTest {
    public PositionMapper positionMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.positionMapper = sqlSession.getMapper(PositionMapper.class);
    }

    @Test
    public void queryPositionTeacherResultMapById() {
        Position position = this.positionMapper.queryPositionTeacherResultMapById(3);
        System.out.println(position);
    }

    @Test
    public void queryPositionTeacherResultMap() {
        List<Position> list = this.positionMapper.queryPositionTeacherResultMap();
        for(Position position :list){
            System.out.println(position);
        }
    }

    @Test
    public void selectPositionStudentByPosId(){
        Position pos = this.positionMapper.selectPositionStudentByPosId(2);
        System.out.println(pos);
    }
}