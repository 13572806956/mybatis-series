package com.me.mybatis.chat01;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
}
