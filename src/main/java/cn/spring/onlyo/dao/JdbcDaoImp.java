package cn.spring.onlyo.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.spring.onlyo.entity.Student;
import cn.spring.onlyo.util.JdbcBasicDao;
import cn.spring.onlyo.util.RowMapperT;

@Repository
public class JdbcDaoImp extends JdbcBasicDao implements JdbcDao {

    /*
     * @Resource
     * public void setMyDataSource(DataSource ds) {
     * super.setDataSource(ds);
     * }
     */

    @Override
    public Student findById(Integer id) {
        String sql = "select * from student where id = ?";
        Object[] params = { id };
        RowMapper rm = new RowMapperT();
        Student s = (Student) getJdbcTemplate().queryForObject(sql, params, rm);
        return s;
    }

    public void test() {

    }
}
