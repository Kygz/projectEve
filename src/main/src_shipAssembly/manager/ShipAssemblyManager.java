package manager;

import po.ShipAssemblyPo;

import java.util.List;
import java.util.Map;

public interface ShipAssemblyManager {

    void insertShipAssemblyPo(ShipAssemblyPo po);

    List<ShipAssemblyPo> queryShipAssemblyPo(Map<String,Object> queryParams);


}
