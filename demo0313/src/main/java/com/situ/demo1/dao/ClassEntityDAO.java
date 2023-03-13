package com.situ.demo1.dao;

import com.situ.demo1.model.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassEntityDAO {
    ClassEntity findById(Integer id);
}
