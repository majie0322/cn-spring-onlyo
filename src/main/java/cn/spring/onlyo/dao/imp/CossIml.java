package cn.spring.onlyo.dao.imp;

import cn.spring.onlyo.dao.CossDao;

public class CossIml implements CossDao {
    @Override
    public void coss() {
        System.out.println("消费");
    }
}
