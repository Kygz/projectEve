package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipAssemblyUtil {
    /**
     * 转换游戏中的导出文本
     * 目前的格式是
     * [船只,方案名称]
     * 低
     * 中
     * 高
     * 改装件
     * @param text
     * @param itemMap
     * @return
     */
    public static Map<String, List<String>> getItemsFromText(String text,Map<String,Long> itemMap, Map<String,Long> shipMap){
        Map<String,List<String>> assemblyMap = new HashMap<String, List<String>>();

        return assemblyMap;
    }
}
