package po;

import util.SysUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolePo {

    private long role_id;
    private String role_key;
    private String role_name;
    private String role_id_list;

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

    public String getRole_id_list() {
        return role_id_list;
    }

    public void setRole_id_list(String role_id_list) {
        this.role_id_list = role_id_list;
    }

    public List<Long> getRoleIdList(){
        List<Long> list = new ArrayList<Long>();
        if(this.role_id_list != null && this.role_id_list != ""){
            String[] tempList = this.role_id_list.split("\\|");
            for(String idStr : tempList){
                Long id = Long.parseLong(idStr);
                list.add(id);
            }
        }
        return list;
    }
    public void setIdIfNew(){
        this.setRole_id(SysUtil.longUUID());
    }
}
