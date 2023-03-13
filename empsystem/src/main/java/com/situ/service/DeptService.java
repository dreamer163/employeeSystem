package com.situ.service;

import com.situ.model.Dept;
import com.situ.model.DeptSearchBean;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.util.PaginateInfo;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    List<Dept> findAll(DeptSearchBean dsb, PaginateInfo pi);

    int deleteByIds(Integer[] depIds);

    boolean add(Dept dept);

    boolean update(Dept dept);

    Dept findByDepId(String depId);
}
