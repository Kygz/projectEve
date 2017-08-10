package manager;

import dao.ShipAssemblyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ShipAssemblyPo;

import java.util.List;
import java.util.Map;

@Service
public class ShipAssemblyManagerImpl implements ShipAssemblyManager{
    @Autowired
    private ShipAssemblyDao shipAssemblyDao;

    public void insertShipAssemblyPo(ShipAssemblyPo po) {
        shipAssemblyDao.insertShipAssemblyPo(po);
    }

    public List<ShipAssemblyPo> queryShipAssemblyPo(Map<String, Object> queryParams) {
        return shipAssemblyDao.queryShipAssemblyPo(queryParams);
    }
}
