package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionMapper {
    /*
    * 根据职位查看教师，实现一对多查询*/
    public Position queryPositionTeacherResultMapById(Integer id);

    public List<Position> queryPositionTeacherResultMap();


    /*
    * 根据职位是教授的教师所教授的所有学生，实现多对多查询*/
    public Position selectPositionStudentByPosId(Integer id);
}
