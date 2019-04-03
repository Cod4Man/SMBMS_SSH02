package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import cn.smbms.tools.StringUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private  SessionFactory sessionFactory;

    private  Session session() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public int add(User user) {
        return (int) session().save(user);
    }

    @Override
    public User getLoginUser(String userCode) {
        StringBuilder hql = new StringBuilder("from User where 1=1 ");
        if (!StringUtil.isNull(userCode)) {
            hql.append(" and userCode=:userCode");
        }
        Query query = session().createQuery(hql.toString());
        query.setParameter("userCode", userCode);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getUserList(String userName, int userRole,int currentPageNo, int pageSize) {
        StringBuilder hql = new StringBuilder("from User where 1=1 ");
        if (!StringUtil.isNull(userName)) {
            hql.append(" and userName like :userName");
        }
        if (userRole > 0 ) {
            hql.append(" and userRole=:userRole");
        }
        Query query = session().createQuery(hql.toString());
        if (!StringUtil.isNull(userName)) {
            query.setParameter("userName", "%" +userName + "%");
        }
        if (userRole > 0 ) {
            query.setParameter("userRole", userRole);
        }
        query.setFirstResult((currentPageNo-1) * pageSize);
        query.setMaxResults(pageSize);
        List<User> users = (List<User>) query.list();
        return users;
    }

    @Override
    public long getUserCount(String userName, int userRole) {
        StringBuilder hql = new StringBuilder("select count(1) from User where 1=1 ");
        if (!StringUtil.isNull(userName)) {
            hql.append(" and userName like :userName");
        }
        if (userRole > 0 ) {
            hql.append(" and  userRole=:userRole");
        }
        System.out.println("getUserCount--HQL:"+hql.toString());
        Query query = session().createQuery(hql.toString());
        if (!StringUtil.isNull(userName)) {
            query.setParameter("userName", "%" +userName + "%");
        }
        if (userRole > 0 ) {
            query.setParameter("userRole", userRole);
        }
        long count = (long) query.uniqueResult();
        return count;
    }

    @Override
    public int deleteUserById(Integer delId) {
        User user = new User();
        user.setId(delId);
        try {
            session().delete(user);
            return 1;
        }catch (HibernateException e) {
            return 0;
        }
    }

    @Override
    public User getUserById(String id) {
        return (User) session().get(User.class, Integer.parseInt(id));
    }

    @Override
    public int modify(User user) {
        try {
            session().merge(user);
            return 1;
        }catch (HibernateException e) {
            return 0;
        }
    }

    @Override
    public int updatePwd(User user) {
        try {
            System.out.println("userDao.modify");
            session().merge(user);
            return 1;
        }catch (HibernateException e) {
            return 0;
        }
    }
}