package dao;

import po.ShipAssemblyPo;

import java.util.Date;
import java.util.List;

public interface ShipAssemblyStatisticsDao {
    int queryShipAssemblyByDate(Date start, Date end);
    List<ShipAssemblyPo> queryShipAssemblyBy7Days();
}
