package cn.smbms.service.role;

import cn.smbms.dao.role.RoleDaoImpl;
import cn.smbms.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
//@Transactional
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleDaoImpl roleDaoImpl;

    @Override
    public List<Role> getRoleList() {
        return roleDaoImpl.getRoleList();
    }

	/*private SqlSession sqlSession;
	@Override
	public List<Role> getRoleList() {
        List<Role> roleList = new ArrayList<>();
        sqlSession = MyBatisUtil.getSqlSession();
        try {
             roleList = sqlSession.getMapper(RoleDao.class).getRoleList();
             sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
		return roleList;
	}*/
}
