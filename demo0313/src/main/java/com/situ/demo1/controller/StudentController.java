package com.situ.demo1.controller;

import com.situ.demo1.model.Student;
import com.situ.demo1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/list/{pn}/{ps}")
    public String list(@PathVariable("pn") Integer pageNo,
                       @PathVariable("ps") Integer pageSize,
                       Map<String, Object> map) {

        List<Student> studentList = service.findAll(pageNo, pageSize);

        map.put("students", studentList);
        return "student/list";
    }
}
