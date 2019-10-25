package com.zpc.mybatis.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Position implements Serializable {
    private int id;
    private String name;

    private Teacher teacher;
}
