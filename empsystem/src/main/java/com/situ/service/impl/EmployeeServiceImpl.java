package com.situ.service.impl;

import com.situ.dao.EmployeeDAO;
import com.situ.dao.impl.EmployeeDAOImpl;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.EmployeeService;
import com.situ.util.BeanFactory;
import com.situ.util.PaginateInfo;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO dao = BeanFactory.getBean(EmployeeDAOImpl.class);

    @Override
    public List<Employee> findAll(EmployeeSearchBean ssb, PaginateInfo pi) {
        return dao.findAll(ssb, pi);
    }

    @Override
    public Employee findByEmpId(String empId) {
        return dao.findByEmpId(empId);
    }

    @Override
    public int deleteByIds(Integer[] empIds) {
        int count = 0;
        for (Integer empId : empIds) {
            boolean b = dao.deleteById(empId);
            if (b) {

                count++;
            }
        }
        return count;
    }
    public boolean add(Employee emp){
        return dao.add(emp) >0;
    }

    @Override
    public boolean update(Employee emp) {
        return dao.update(emp)>0;
    }

}
