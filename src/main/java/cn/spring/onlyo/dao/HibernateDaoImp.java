package cn.spring.onlyo.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.spring.onlyo.entity.Student;

@Component
public class HibernateDaoImp extends HibernateDaoSupport implements JdbcDao {

    /*
     * @Autowired
     * private HibernateTemplate ht;
     */
    @Resource
    public void setMySession(SessionFactory sf) {
        super.setSessionFactory(sf);
    }

    @Override
    public Student findById(Integer id) {
        Student st = getHibernateTemplate().get(Student.class, id);
        return st;
    }
}
