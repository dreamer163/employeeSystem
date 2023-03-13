package com.situ.demo1.service.impl;

import com.situ.demo1.dao.StudentDAO;
import com.situ.demo1.model.Student;
import com.situ.demo1.service.StudentService;
import com.situ.demo1.uitl.Pager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO dao;
    private SqlSessionFactory sf;

    @Autowired
    public void setSf(SqlSessionFactory sf) {
        this.sf = sf;
    }

    public StudentServiceImpl(StudentDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Student> findAll(Integer pageNo, Integer pageSize) {
        //return dao.findAll(Map.of("pageNo", pageNo, "pageSize", pageSize));
        //Pager pager = new Pager(3, 15);
        ///return dao.findAll(pager);

        /*SqlSession session = sf.openSession();//创建了一个会话
        Map<String, Object> map = Map.of("pageNo", pageNo, "pageSize", pageSize);
        session.selectList("com.situ.demo1.dao.StudentDAO.findAll", map);

        session.selectList("com.situ.demo1.dao.StudentDAO.findAll", map);

        session.selectList("com.situ.demo1.dao.StudentDAO.findAll", map);

        session.selectList("com.situ.demo1.dao.StudentDAO.findAll", map);

        List<Student> students = session.selectList("com.situ.demo1.dao.StudentDAO.findAll", map);

        session.close();*/
        Map<String, Object> map = Map.of("pageNo", pageNo, "pageSize", pageSize);
        return dao.findAll(map);
        /*return students;*/
    }
}
