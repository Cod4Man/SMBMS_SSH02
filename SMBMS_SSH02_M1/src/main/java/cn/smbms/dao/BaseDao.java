package cn.smbms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

public class BaseDao {
    @Resource
    protected SessionFactory sessionFactory;

    protected  Session session() {
        return this.sessionFactory.getCurrentSession();
    }

}