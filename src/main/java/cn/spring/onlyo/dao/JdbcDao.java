package cn.spring.onlyo.dao;

import cn.spring.onlyo.entity.Student;

public interface JdbcDao {

    Student findById(Integer id);
}
