package po;

import java.util.Map;

/**
 * 吉他姬的小对象
 * Created by gavin on 2016/5/11 0011.
 */
public class JitaItem {
    private Map<String,Double> sell;
    private Map<String,Double> all;
    private Map<String,Double> buy;

    public Map<String, Double> getSell() {
        return sell;
    }

    public void setSell(Map<String, Double> sell) {
        this.sell = sell;
    }

    public Map<String, Double> getAll() {
        return all;
    }

    public void setAll(Map<String, Double> all) {
        this.all = all;
    }

    public Map<String, Double> getBuy() {
        return buy;
    }

    public void setBuy(Map<String, Double> buy) {
        this.buy = buy;
    }
    //{"sell": {"volume": 25135121388, "max": 20000000.0, "min": 12.63}, "all": {"volume": 58356222717, "max": 20000000.0, "min": 3.01}, "buy": {"volume": 33221101329, "max": 12.05, "min": 3.01}}
}
