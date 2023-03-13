package com.situ.demo1.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClassEntity {
    private Integer id;
    private String name;

    private LocalDate beginTime;

    private List<Student> students;

}
