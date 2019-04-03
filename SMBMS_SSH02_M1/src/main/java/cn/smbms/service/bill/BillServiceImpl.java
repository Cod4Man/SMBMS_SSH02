package cn.smbms.service.bill;

import cn.smbms.dao.bill.BillDaoImpl;
import cn.smbms.pojo.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
//@Transactional
public class BillServiceImpl implements BillService {
	@Resource
	private BillDaoImpl billDaoImpl;

	@Override
	public boolean add(Bill bill) {
		boolean result = false;
		if (billDaoImpl.add(bill) > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public List<Bill> getBillList(Bill bill) {
		return billDaoImpl.getBillList(bill);
	}

	@Override
	public boolean deleteBillById(String delId) {
		boolean result = false;
		if (billDaoImpl.deleteBillById(delId) > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public Bill getBillById(String id) {
		return billDaoImpl.getBillById(id);
	}

	@Override
	public boolean modify(Bill bill) {
		boolean result = false;
		if (billDaoImpl.modify(bill) > 0) {
			result = true;
		}
		return result;
	}
/*
	private SqlSession sqlSession;
	public BillServiceImpl(){
	}
	@Override
	public boolean add(Bill bill) {
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			if(sqlSession.getMapper(BillDao.class).add(bill) > 0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (sqlSession != null) {
				sqlSession.rollback();
			}
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public List<Bill> getBillList(Bill bill) {
		List<Bill> billList = null;
		System.out.println("query productName ---- > " + bill.getProductName());
		System.out.println("query providerId ---- > " + bill.getProviderId());
		System.out.println("query isPayment ---- > " + bill.getIsPayment());
		
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			billList = sqlSession.getMapper(BillDao.class).getBillList( bill);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (sqlSession != null) {
				sqlSession.rollback();
			}
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return billList;
	}

	@Override
	public boolean deleteBillById(String delId) {
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			if(sqlSession.getMapper(BillDao.class).deleteBillById(delId) > 0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (sqlSession != null) {
				sqlSession.rollback();
			}
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public Bill getBillById(String id) {
		Bill bill = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			bill = sqlSession.getMapper(BillDao.class).getBillById(id);
			sqlSession.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (sqlSession != null) {
				sqlSession.rollback();
			}
			bill = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return bill;
	}

	@Override
	public boolean modify(Bill bill) {
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			if(sqlSession.getMapper(BillDao.class).modify(bill) > 0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (sqlSession != null) {
				sqlSession.rollback();
			}
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}
*/

}
