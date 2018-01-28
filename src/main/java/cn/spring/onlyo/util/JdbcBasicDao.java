package cn.spring.onlyo.util;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcBasicDao extends JdbcDaoSupport {

    @Resource
    public void setMyDataSource(DataSource ds) {
        super.setDataSource(ds);

    }
}
