package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import po.JitaItem;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class JitaUtil {
    private static final Log log = LogFactory.getLog(JitaUtil.class);
    private static final Map<String,String> planetObjMap = new HashMap<String,String>();
    private static final String JITA_PRICE_URL          = "https://www.ceve-market.org/api/market/region/{REGION}/system/{SYSTEM}/type/{ITEM}.{FORMAT}";
    private static final String JITA_SEARCH_NAME_URL    = "https://www.ceve-market.org/api/searchname";
    private static final String JITA_MINERAL_PRICE_URL  = "https://www.ceve-market.org/api/evemon";
    /**
     * 吉他查价
     * 链接：https://www.ceve-market.org/api/market/region/{星域ID}/system/{星系ID}/type/{物品ID}.{格式}
     * 格式：{"sell": {"volume": 25135121388, "max": 20000000.0, "min": 12.63}, "all": {"volume": 58356222717, "max": 20000000.0, "min": 3.01}, "buy": {"volume": 33221101329, "max": 12.05, "min": 3.01}}
     * @param itemId
     * @return
     */
    public static JitaItem getItemInfo(String itemId){
        String urlStr = "http://www.ceve-market.org/api/market/region/10000002/type/" + itemId + ".json";
        String result = NetUtil.createNetConnection(urlStr, "GET",null);
        try {
            System.out.println(result);
            return SysUtil.createGson().fromJson(result, JitaItem.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String[]> jitaItemNameSearch(String itemName){
        if(StringUtil.isNotBlank(itemName)){
            Map<String,String> searchItem = new HashMap<String, String>();
            searchItem.put("name",itemName);
            String result = NetUtil.createNetConnection(JITA_SEARCH_NAME_URL, "POST", SysUtil.createGson().toJson(searchItem));
            Object o = SysUtil.createGson().fromJson(result,Object.class);
            return null;
        }else{
            return null;
        }
    }

    public static String getP1IdbyName(String name){
        if(planetObjMap.keySet().size() == 0){
            planetObjMap.put("等离子体团","2389");
            planetObjMap.put("电解物","2390");
            planetObjMap.put("氧化剂","2392");
            planetObjMap.put("细菌","2393");
            planetObjMap.put("蛋白质","2395");
            planetObjMap.put("生物燃料","2396");
            planetObjMap.put("工业纤维","2397");
            planetObjMap.put("反应金属","2398");
            planetObjMap.put("稀有金属","2399");
            planetObjMap.put("有毒金属","2400");
            planetObjMap.put("手性结构","2401");
            planetObjMap.put("水","3645");
            planetObjMap.put("氧","3683");
            planetObjMap.put("生物质","3779");
            planetObjMap.put("硅","9828");
        }
        return planetObjMap.get(name);
    }

    public static List<Map<String,String>> getJitaMineralPrice(){
        List<Map<String,String>> priceList = new ArrayList<>();
        String result = NetUtil.createNetConnection(JITA_MINERAL_PRICE_URL, "GET","");
        // 创建一个新的字符串
        StringReader xmlString = new StringReader(result);
        // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(xmlString);
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(source);
            Element minerals = document.getRootElement();
            List<Element> mineralList = minerals.getChildren("mineral");
            mineralList.forEach( mineral -> {
                String name = mineral.getChildText("name");
                String price = mineral.getChildText("price");
                HashMap<String,String> item = new HashMap<>();
                item.put("name",name);
                item.put("price",price);
                priceList.add(item);
            });
        }catch (JDOMException | IOException e) {
            log.error("xml解析出错",e);
        }
        return priceList;
    }
}
