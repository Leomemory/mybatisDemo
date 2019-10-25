package com.zpc.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Student implements Serializable {
    private String id;
    private String name;

    private List<Teacher> list;
}
