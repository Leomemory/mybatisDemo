package com.zpc.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Teacher implements Serializable {
    private int id;
    private String no;
    private String name;

    private List<Student> studentList;
    private Position pos;
}
