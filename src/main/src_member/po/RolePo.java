package po;

import util.SysUtil;

public class RolePo {

    private long role_id;
    private String role_key;
    private String role_name;
    private long role_id_list;

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_key() {
        return role_key;
    }

    public void setRole_key(String role_key) {
        this.role_key = role_key;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public long getRole_id_list() {
        return role_id_list;
    }

    public void setRole_id_list(long role_id_list) {
        this.role_id_list = role_id_list;
    }

    public void setIdIfNew(){
        this.setRole_id(SysUtil.longUUID());
    }
}
