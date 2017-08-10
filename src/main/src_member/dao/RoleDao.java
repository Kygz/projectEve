package dao;

import po.RolePo;


public interface RoleDao {
    RolePo queryRoleById(Long id);
    RolePo queryRoleByKey(String key);
    void insertRole(RolePo po);
    void updateRole(RolePo po);
}
