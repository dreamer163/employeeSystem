package com.situ.service;

import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.util.PaginateInfo;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询全部
     *
     * @param esb
     * @param pi
     * @return
     */
    List<Employee> findAll(EmployeeSearchBean esb, PaginateInfo pi);

    Employee findByEmpId(String empId);

    //删除记录
    int deleteByIds(Integer[] empIds);

    boolean add(Employee emp);

    boolean update(Employee emp);
}
