package manager;

import dao.JitaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ItemPo;
import po.JitaGroupPo;
import po.JitaItem;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 取JitaItem Manager
 */
@Service
public class JitaManagerImpl implements JitaManager{
    @Autowired
    private JitaDao jitaDao;

    public JitaItem queryJitaItemById(String id) {

        return null;
    }

    public List<ItemPo> queryJitaItemNameListByName(String itemName){
        return jitaDao.queryJitaItemByName(itemName);
    }

    //-------------------------------
    public List<JitaGroupPo> queryJitaGroupsByUserId(Long userId){
        List result;
        result = jitaDao.queryJitaGroupsByUserId(userId);
        if(result == null){
            result = new ArrayList<>();
        }
        return result;
    }

    public void saveJitaGroup(JitaGroupPo jitaGroupPo){

    }
}
