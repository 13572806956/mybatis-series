package com.me.chat02;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Integer sex;
}
