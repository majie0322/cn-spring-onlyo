package cn.spring.onlyo.dao;

import cn.spring.onlyo.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class JdbcDaoImpTest {

    @Test
    public void findById() throws Exception {

        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcDao jd = (JdbcDao)ac.getBean("jdbcDaoImp");
        Student s = jd.findById(1);
        System.out.println(s);
    }

}