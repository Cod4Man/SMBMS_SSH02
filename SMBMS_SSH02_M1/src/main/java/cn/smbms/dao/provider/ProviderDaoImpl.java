package cn.smbms.dao.provider;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Provider;
import cn.smbms.tools.StringUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderDaoImpl extends BaseDao implements ProviderDao {
    @Override
    public int add(Provider provider) {
        try {
            session().save(provider);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) {
        StringBuilder sb = new StringBuilder("from Provider where 1=1 ");
        if (!StringUtil.isNull(proName)) {
            sb.append(" and proName like :proName ");
        }
        if (!StringUtil.isNull(proCode)) {
            sb.append(" and proCode like :proCode ");
        }
        Query query = session().createQuery(sb.toString());
        if (!StringUtil.isNull(proName)) {
            query.setParameter("proName", "%" + proName + "%");
        }
        if (!StringUtil.isNull(proCode)) {
            query.setParameter("proCode", "%" + proCode + "%");
        }
        return query.list();
    }

    @Override
    public int deleteProviderById(String delId) {
        try {
            Provider p = new Provider();
            p.setId(Integer.parseInt(delId));
            session().delete(p);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Provider getProviderById(String id) {
        return (Provider) session().get(Provider.class, Integer.parseInt(id));
    }

    @Override
    public int modify(Provider provider) {
        try {
            session().merge(provider);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 0;
        }
    }
}