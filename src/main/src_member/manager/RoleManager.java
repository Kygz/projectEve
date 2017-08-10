package manager;

import po.RolePo;

public interface RoleManager {
    RolePo queryRoleById(Long id);
    RolePo queryRoleByKey(String key);
    void insertRole(RolePo po);
    void updateRole(RolePo po);
}
