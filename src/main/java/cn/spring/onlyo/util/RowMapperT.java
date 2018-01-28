package cn.spring.onlyo.util;


import cn.spring.onlyo.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperT implements RowMapper {


    /**
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Student st = new Student();
        st.setId(resultSet.getInt("id"));
        st.setAge(resultSet.getInt("age"));
        st.setName(resultSet.getString("name"));
        st.setScore(resultSet.getInt("score"));
        return st;
    }
}
