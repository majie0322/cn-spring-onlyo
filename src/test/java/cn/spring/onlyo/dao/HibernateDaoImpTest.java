package cn.spring.onlyo.dao;

import cn.spring.onlyo.entity.Student;
import javassist.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateDaoImpTest {

    @Autowired
    private HibernateDaoImp hibernateDaoImp;

    @Test
    public void findById() throws Exception {
        /*
         * ApplicationContext ac = new
         * ClassPathXmlApplicationContext("applicationContext.xml");
         * JdbcDao jc = (HibernateDaoImp)ac.getBean("hibernateDaoImp");
         */
        Student s = hibernateDaoImp.findById(1);
        System.out.println(s);
    }

}
