package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import po.JitaItem;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class JitaUtil {
    public static JitaItem getItemInfo(String itemId){
        String urlStr = "http://www.ceve-market.org/api/market/region/10000002/type/"+itemId+".json";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.connect();
            String content = "";
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content += line;
                }
                System.out.println(content);
                JitaItem item = SysUtil.createGson().fromJson(content,JitaItem.class);
                return item;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//{"sell": {"volume": 25135121388, "max": 20000000.0, "min": 12.63}, "all": {"volume": 58356222717, "max": 20000000.0, "min": 3.01}, "buy": {"volume": 33221101329, "max": 12.05, "min": 3.01}}
        return null;
    }

    public static String getP1IdbyName(String name){
        Map<String,String> itemMap = new HashMap<String, String>();
        itemMap.put("等离子体团","2389");
        itemMap.put("电解物","2390");
        itemMap.put("氧化剂","2392");
        itemMap.put("细菌","2393");
        itemMap.put("蛋白质","2395");
        itemMap.put("生物燃料","2396");
        itemMap.put("工业纤维","2397");
        itemMap.put("反应金属","2398");
        itemMap.put("稀有金属","2399");
        itemMap.put("有毒金属","2400");
        itemMap.put("手性结构","2401");
        itemMap.put("水","3645");
        itemMap.put("氧","3683");
        itemMap.put("生物质","3779");
        itemMap.put("硅","9828");

        return itemMap.get(name);
    }
}
