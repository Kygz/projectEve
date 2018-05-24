package manager;

import dao.ShipAssemblyStatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ShipAssemblyPo;
import util.DateUtil;

import java.util.Date;
import java.util.List;

@Service
public class ShipAssemblyStatisticsManagerImpl implements ShipAssemblyStatisticsManager{
    @Autowired
    ShipAssemblyStatisticsDao shipAssemblyStatisticsDao;

    public int queryShipAssemblyByDate(Date start, Date end) {
        List<ShipAssemblyPo> list = shipAssemblyStatisticsDao.queryShipAssemblyBy7Days();
        Date startDate = DateUtil.get7DaysBefore();
        for (ShipAssemblyPo po : list){

        }
        return 0;
    }
}
