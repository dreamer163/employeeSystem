package com.situ.dao;

import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.model.User;
import com.situ.util.PaginateInfo;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll(EmployeeSearchBean esb, PaginateInfo pi);

    Employee findByEmpId(String empId);

    //根据员工编号删除一条记录
    boolean deleteById(Integer empId);

    int add(Employee emp);

    int update(Employee emp);

}
