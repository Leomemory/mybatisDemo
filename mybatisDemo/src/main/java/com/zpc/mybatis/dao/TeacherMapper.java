package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> queryTeacherPositionResultMap();

    public Teacher queryTeacherPositionResultMapById(Integer id);
}
