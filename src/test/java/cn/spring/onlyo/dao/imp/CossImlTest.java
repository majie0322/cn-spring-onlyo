package cn.spring.onlyo.dao.imp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.onlyo.dao.CossDao;

public class CossImlTest {

    @Test
    public void coss() throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        CossDao co = (CossIml) ac.getBean("coss");
        co.coss();
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestAction ta = (TestAction) ac.getBean("action");
        ta.execute();
    }
}
