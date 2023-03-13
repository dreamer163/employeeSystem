package com.situ.dao.impl;

import com.situ.dao.DeptDAO;
import com.situ.global.Global;
import com.situ.model.Dept;
import com.situ.model.DeptSearchBean;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.util.PaginateInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DeptDAOImpl implements DeptDAO {
    private final JdbcTemplate template = new JdbcTemplate(Global.getDataSource());


    @Override
    public List<Dept> findAll() {
        String sql = "select dep_id,name,leader from t_department";
        List<Dept> depts = template.query(sql, new BeanPropertyRowMapper(Dept.class));
        return depts;
    }

    public boolean deleteById(Integer depId) {
        String sql = "delete from t_department where dep_id = ?";
        int rows = template.update(sql, depId);
        return rows > 0;
    }

    @Override
    public int add(Dept dept) {
        String sql = "insert into t_department" +
                "(dep_id,name,leader)" +
                "values(?,?,?)";

        int rows = template.update(sql, dept.getDepId(), dept.getName(), dept.getLeader());
        return rows;
    }

    @Override
    public int update(Dept dept) {
        String sql = "update t_department set name=?,leader=? where dep_id=?";

        int rows = template.update(sql, dept.getName(), dept.getLeader(), dept.getDepId());

        return rows;

    }

    @Override
    public Dept findByDepId(String depId) {

        String sql = "select dep_id,name,leader from t_department where dep_id =?";

        List<Dept> depts = template.query(sql, new BeanPropertyRowMapper(Dept.class), depId);

        return depts.size() > 0 ? depts.get(0) : null;

    }

    @Override
    public List<Dept> findAll(DeptSearchBean dsb, PaginateInfo pi) {
        String sql = "select dep_id,name,leader from t_department ";
        String countSql = "select count(0) from t_department";//查询总数

        List<Object> args = new ArrayList<>();

        StringBuilder whereSql = new StringBuilder();

        if (dsb != null) {
            whereSql.append(" where 1=1");
            if (StringUtils.hasText(dsb.getDepId())) {
                whereSql.append(" and dep_id= ?");
                args.add(dsb.getDepId());
            }
            if (StringUtils.hasText(dsb.getName())) {
                whereSql.append(" and name= ?");
                args.add(dsb.getName());
            }
            if (StringUtils.hasText(dsb.getLeader())) {
                whereSql.append(" and leader= ?");
                args.add(dsb.getLeader());
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


        List<Dept> depts = template.query(sql, new BeanPropertyRowMapper(Dept.class), args.toArray());
        return depts;
    }

}


