package com.yc.Lwc.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liweicheng
 * @create 2020/10/31 - 16:29
 */
@Data
public class User implements Serializable {
    private String name;
    private int age;
    private String sex;

}