package manager;

import dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.RolePo;

@Service
public class RoleManagerImpl implements RoleManager{
    @Autowired
    private RoleDao roleDao;

    public RolePo queryRoleById(Long id) {
        return roleDao.queryRoleById(id);
    }

    public RolePo queryRoleByKey(String key) {
        return roleDao.queryRoleByKey(key);
    }

    public void insertRole(RolePo po) {
        roleDao.insertRole(po);
    }

    public void updateRole(RolePo po) {
        roleDao.updateRole(po);
    }

}
