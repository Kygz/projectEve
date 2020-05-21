package manager;

import dao.ShipAssemblyDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ShipAssemblyPo;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShipAssemblyManagerImpl implements ShipAssemblyManager{
    private static Log log = LogFactory.getLog(ShipAssemblyManagerImpl.class);

    @Autowired
    private ShipAssemblyDao shipAssemblyDao;

    private Map<String,Long> shipEquipmentMap = null;
    private Map<String,Long> shipMap = null;

    public Map<String, Long> getShipEquipmentMap() {
        if(shipEquipmentMap == null){
            init();
        }
        return shipEquipmentMap;
    }

    public Map<String, Long> getShipMap() {
        if(shipMap == null){
            init();
        }
        return shipMap;
    }

    public void init(){
        List<Object[]> items = shipAssemblyDao.queryAllShipEquipment();
        shipEquipmentMap = new HashMap<>();
        if(items !=null && items.size() >0){
            for (Object[] item : items) {
                shipEquipmentMap.put((String)item[1],(Long)item[0]);
            }
        }
        List<Object[]> ships = shipAssemblyDao.queryShipList();
        shipMap = new HashMap<>();
        if(ships !=null && ships.size() >0){
            for (Object[] ship : ships) {
                shipMap.put((String)ship[1],(Long)ship[0]);
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

    public Map<String,List<String>> getItemsFromText(String shipInfo,String c1,String c2,String c3,String c4){
        return null;
    }
}
