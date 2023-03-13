package com.situ.demo1.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//@Setter
//@Getter
//@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private String phone;

    private String py;

    private LocalDate birthday;

    private ClassEntity classEntity;//所在班级
}
