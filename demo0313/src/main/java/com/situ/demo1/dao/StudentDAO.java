package com.situ.demo1.dao;

import com.situ.demo1.model.Student;
import com.situ.demo1.uitl.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentDAO {
    List<Student> findAll(Map<String,Object> map);


    /*List<Student> findAll(@Param("pn") Integer pageNo,
                          @Param("ps") Integer pageSize);*/

    /*List<Student> findAll(@Param("pager") Pager pager);*/

    int deleteByIds(@Param("ids") Integer[] ids);
}
