package com.situ.demo1.service;

import com.situ.demo1.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll(Integer pageNo, Integer pageSize);
}
