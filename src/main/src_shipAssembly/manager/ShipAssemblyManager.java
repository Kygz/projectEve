package manager;

import po.ShipAssemblyPo;

import java.util.List;
import java.util.Map;

public interface ShipAssemblyManager {
    Map<Long,String> getShipEquipmentMap();
    Map<Long,String> getShipMap();
    void insertShipAssemblyPo(ShipAssemblyPo po);
    List<ShipAssemblyPo> queryShipAssemblyPo(Map<String,Object> queryParams);
    ShipAssemblyPo queryShipAssemblyPoById(Long id);
    Map<String,List<String[]>> getItemsFromText(String shipInfo,String c1);
}
