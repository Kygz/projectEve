package manager;

import java.util.Date;

public interface ShipAssemblyStatisticsManager {
    int queryShipAssemblyByDate(Date start,Date end);
}
