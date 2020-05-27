package manager;

import dao.ShipAssemblyDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ShipAssemblyPo;
import util.StringUtil;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShipAssemblyManagerImpl implements ShipAssemblyManager{
    private static Log log = LogFactory.getLog(ShipAssemblyManagerImpl.class);

    @Autowired
    private ShipAssemblyDao shipAssemblyDao;

    private Map<Long,String> shipEquipmentMap = null;
    private Map<Long,String> shipModMap = null;
    private Map<Long,String> shipSubSystemMap = null;
    private Map<Long,String> shipAmmunitionAndScriptMap = null;
    private Map<Long,String> shipMap = null;

    public Map<Long,String> getShipEquipmentMap() {
        if(shipEquipmentMap == null){
            init();
        }
        return shipEquipmentMap;
    }

    public Map<Long,String> getShipMap() {
        if(shipMap == null){
            init();
        }
        return shipMap;
    }

    public Map<Long, String> getShipModMap() {
        if(shipModMap == null){
            init();
        }
        return shipModMap;
    }

    public Map<Long, String> getShipSubSystemMap() {
        if(shipSubSystemMap == null){
            init();
        }
        return shipSubSystemMap;
    }

    public Map<Long, String> getShipAmmunitionAndScriptMap() {
        if(shipAmmunitionAndScriptMap == null){
            init();
        }
        return shipAmmunitionAndScriptMap;
    }

    public void init(){
        List<Object[]> items = shipAssemblyDao.queryAllShipEquipment();
        shipEquipmentMap = new HashMap<>();
        if(items !=null && items.size() >0){
            for (Object[] item : items) {
                shipEquipmentMap.put((Long)item[0],(String)item[1]);
            }
        }
        List<Object[]> shipMods = shipAssemblyDao.queryAllShipMod();
        shipModMap = new HashMap<>();
        if(shipMods !=null && shipMods.size() >0){
            for (Object[] mod : shipMods) {
                shipModMap.put((Long)mod[0],(String)mod[1]);
            }
        }
        List<Object[]> subsystems = shipAssemblyDao.queryAllShipSubsystem();
        shipSubSystemMap = new HashMap<>();
        if(subsystems !=null && subsystems.size() >0){
            for (Object[] subsystem : subsystems) {
                shipSubSystemMap.put((Long)subsystem[0],(String)subsystem[1]);
            }
        }
        List<Object[]> ammunitionAndScripts = shipAssemblyDao.queryAllShipAmmunitionAndScript();
        shipAmmunitionAndScriptMap = new HashMap<>();
        if(ammunitionAndScripts !=null && ammunitionAndScripts.size() >0){
            for (Object[] ammunitionAndScript : ammunitionAndScripts) {
                shipAmmunitionAndScriptMap.put((Long)ammunitionAndScript[0],(String)ammunitionAndScript[1]);
            }
        }
    }

    public void insertShipAssemblyPo(ShipAssemblyPo po) {
        shipAssemblyDao.insertShipAssemblyPo(po);
    }

    public List<ShipAssemblyPo> queryShipAssemblyPo(Map<String, Object> queryParams) {
        return shipAssemblyDao.queryShipAssemblyPo(queryParams);
    }
    public ShipAssemblyPo queryShipAssemblyPoById(Long id) {
        return shipAssemblyDao.queryShipAssemblyPoById(id);
    }

    public Map<String,List<String[]>> getItemsFromText(String shipInfo,String c1){
        Map<String,List<String[]>> result = new HashMap<>();
        Map<Long, String> shipEquipmentMap = getShipEquipmentMap();
        Map<Long, String> shipModMap = getShipModMap();
        Map<Long, String> shipSubSystemMap = getShipSubSystemMap();
        Map<Long, String> shipAmmunitionAndScriptMap = getShipAmmunitionAndScriptMap();
        ArrayList<String[]> itemList = new ArrayList<>();
        ArrayList<String[]> modList = new ArrayList<>();
        ArrayList<String[]> subsystemList = new ArrayList<>();
        ArrayList<String[]> ammList = new ArrayList<>();
        if(StringUtil.isNotBlank(c1)){
            cycle1 :for (String item : c1.split(",")) {
                String[] itemObj = new String[2];
                for (Long itemId : shipEquipmentMap.keySet()) {
                    if(shipEquipmentMap.get(itemId).equals(item)){
                        itemObj[0] = itemId.toString();
                        itemObj[1] = item;
                        itemList.add(itemObj);
                        continue cycle1;
                    }
                }
                for (Long itemId : shipModMap.keySet()) {
                    if(shipModMap.get(itemId).equals(item)){
                        itemObj[0] = itemId.toString();
                        itemObj[1] = item;
                        modList.add(itemObj);
                        continue cycle1;
                    }
                }
                for (Long itemId : shipSubSystemMap.keySet()) {
                    if(shipSubSystemMap.get(itemId).equals(item)){
                        itemObj[0] = itemId.toString();
                        itemObj[1] = item;
                        subsystemList.add(itemObj);
                        continue cycle1;
                    }
                }
                for (Long itemId : shipAmmunitionAndScriptMap.keySet()) {
                    if(shipAmmunitionAndScriptMap.get(itemId).equals(item)){
                        itemObj[0] = itemId.toString();
                        itemObj[1] = item;
                        ammList.add(itemObj);
                        continue cycle1;
                    }
                }
            }
        }
        result.put("c1",itemList);
        result.put("c2",modList);
        result.put("c3",subsystemList);
        result.put("c4",ammList);
        return result;
    }
}
