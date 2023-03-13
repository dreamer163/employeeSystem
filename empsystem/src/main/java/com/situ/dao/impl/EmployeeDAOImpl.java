package com.situ.dao.impl;

import com.situ.dao.EmployeeDAO;
import com.situ.global.Global;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.model.User;
import com.situ.util.PaginateInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate template = new JdbcTemplate(Global.getDataSource());

    @Override
    public List<Employee> findAll(EmployeeSearchBean esb, PaginateInfo pi) {
        String sql = "select emp_id,name,sex,birthday,native_place,hiredate,dep_id from t_employee ";
        String countSql = "select count(0) from t_employee";//查询总数

        List<Object> args = new ArrayList<>();

        StringBuilder whereSql = new StringBuilder();
        if (esb != null) {
            whereSql.append(" where 1=1");
            if (StringUtils.hasText(esb.getEmpId())) {
                whereSql.append(" and emp_id= ?");
                args.add(esb.getEmpId());
            }
            if (StringUtils.hasText(esb.getDepId())) {
                whereSql.append(" and dep_id= ?");
                args.add(esb.getDepId());
            }
            if (StringUtils.hasText(esb.getSex())) {
                whereSql.append(" and sex = ?");
                args.add(esb.getSex());
            }
            if (StringUtils.hasText(esb.getNativePlace())) {
                whereSql.append(" and native_place like ?");
                args.add("%" + esb.getNativePlace() + "%");
            }
            if (StringUtils.hasText(esb.getName())) {
                whereSql.append(" and name like ?");
                args.add("%" + esb.getName() + "%");
            }
        }

        countSql += whereSql.toString();
        //查询总数
        Long count = template.queryForObject(countSql, Long.class, args.toArray());

        pi.setCount(count);

        whereSql.append(" limit ?,?");
        sql += whereSql.toString();

        args.add(pi.getOffset());
        args.add(pi.getLimit());


        List<Employee> emps = template.query(sql, new BeanPropertyRowMapper(Employee.class), args.toArray());
        return emps;
    }

    @Override
    public Employee findByEmpId(String empId) {
        String sql = "select emp_id,name,sex,birthday,native_place,hiredate,dep_id from t_employee where emp_id = ?";
        List<Employee> employees = template.query(sql,
                new BeanPropertyRowMapper(Employee.class), empId);
        return employees.size() > 0 ? employees.get(0) : null;
    }


    //删除记录通过empId
    @Override
    public boolean deleteById(Integer empId) {
        String sql = "delete from t_employee where emp_id = ?";
        int rows = template.update(sql, empId);
        return rows > 0;
    }

    //插入数据

    public int add(Employee emp) {
        String sql = "insert into t_employee" +
                "(emp_id,name,sex,birthday,native_place,hiredate,dep_id)" +
                "values(?,?,?,?,?,?,?)";

        int rows = template.update(sql, emp.getEmpId(), emp.getName(), emp.getSex(), emp.getBirthday(), emp.getNativePlace(), emp.getHiredate(), emp.getDepId());
        return rows;
    }

    @Override
    public int update(Employee emp) {
        String sql = "update t_employee set name=?,sex=?,birthday=?" +
                ",native_place=?,hiredate=?,dep_id=? where emp_id=?";

        int rows = template.update(sql, emp.getName(), emp.getSex(), emp.getBirthday(), emp.getNativePlace(), emp.getHiredate(), emp.getDepId(), emp.getEmpId());

        return rows;
    }
}
