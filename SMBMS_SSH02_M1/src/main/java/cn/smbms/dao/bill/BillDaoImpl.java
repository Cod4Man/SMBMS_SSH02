package cn.smbms.dao.bill;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Bill;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BillDaoImpl extends BaseDao implements BillDao {
    @Override
    public int add(Bill bill) {
        try {
            session().save(bill);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        StringBuilder hql = new StringBuilder("from Bill where 1=1 ");
        if (bill.getProductName() != null && !"".equals(bill.getProductName())) {
            hql.append(" and productName like :productName");
        }
        if (bill.getProvider().getId() != 0) {
            hql.append(" and provider.id =:productId");
        }
        if (bill.getIsPayment() != 0) {
            hql.append(" and isPayment =:isPayment");
        }
        Query query = session().createQuery(hql.toString());
        if (bill.getProductName() != null && !"".equals(bill.getProductName())) {
            query.setParameter("productName", "%" + bill.getProductName() + "%");
        }
        if (bill.getProvider().getId() != 0) {
            query.setParameter("productId", bill.getProvider().getId() );
        }
        if (bill.getIsPayment() != 0) {
            query.setParameter("isPayment", bill.getIsPayment());
        }
        return query.list();
    }

    @Override
    public int deleteBillById(String delId) {
        Bill bill = new Bill();
        bill.setId(Integer.parseInt(delId));
      try {
          session().delete(bill);
          return 1;
      } catch (HibernateException e) {
          e.printStackTrace();
          return -1;
      }
    }

    @Override
    public Bill getBillById(String id) {
        return (Bill) session().get(Bill.class , Integer.parseInt(id));
    }

    @Override
    public int modify(Bill bill) {
        try {
            session().merge(bill);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getBillCountByProviderId(String providerId) {
        Query query = session().createQuery("select count(1) from Bill where providerId=:providerId")
                .setParameter("providerId", providerId);
        try {
            query.uniqueResult();
                    return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return -1;
        }
    }
}