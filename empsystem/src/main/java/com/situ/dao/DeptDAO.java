package com.situ.dao;

import com.situ.model.Dept;
import com.situ.model.DeptSearchBean;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.util.PaginateInfo;

import java.util.List;

public interface DeptDAO {
    List<Dept> findAll();

    List<Dept> findAll(DeptSearchBean dsb, PaginateInfo pi);

    boolean deleteById(Integer depId);

    int add(Dept dept);

    int update(Dept dept);

    Dept findByDepId(String depId);

}
