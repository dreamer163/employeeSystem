package com.situ.service.impl;

import com.situ.dao.DeptDAO;
import com.situ.dao.impl.DeptDAOImpl;
import com.situ.model.Dept;
import com.situ.model.DeptSearchBean;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.DeptService;
import com.situ.util.BeanFactory;
import com.situ.util.PaginateInfo;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private final DeptDAO dao = BeanFactory.getBean(DeptDAOImpl.class);
    @Override
    public List<Dept> findAll() {
        return dao.findAll();
    }

    public List<Dept> findAll(DeptSearchBean dsb, PaginateInfo pi) {
        return dao.findAll(dsb, pi);
    }

    public int deleteByIds(Integer[] depIds) {
        int count = 0;
        for (Integer depId : depIds) {
            boolean b = dao.deleteById(depId);
            if (b) {

                count++;
            }
        }
        return count;
    }

    @Override
    public boolean add(Dept dept) {
        return dao.add(dept)>0;
    }

    @Override
    public boolean update(Dept dept) {
        return dao.update(dept)>0;
    }

    @Override
    public Dept findByDepId(String depId) {

        return dao.findByDepId(depId);
    }
}
