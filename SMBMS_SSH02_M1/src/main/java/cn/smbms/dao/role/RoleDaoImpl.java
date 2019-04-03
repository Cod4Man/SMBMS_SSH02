package cn.smbms.dao.role;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

    @Override
    public List<Role> getRoleList() {
        return session().createQuery("from Role ").list();
    }
}