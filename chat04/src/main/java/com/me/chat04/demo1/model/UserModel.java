package com.me.chat04.demo1.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ME
 * @create 2022-08-02 20:22
 */
@Data
@Builder
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Integer sex;
}
