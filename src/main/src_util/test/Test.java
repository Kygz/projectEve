package test;

import po.JitaItem;
import sun.misc.BASE64Encoder;
import util.DateUtil;
import util.JitaUtil;
import util.NetUtil;
import util.SysUtil;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class Test {
    public static void main(String[] args) {
//        JitaItem item = JitaUtil.getItemInfo("34");
//        DecimalFormat df =new   java.text.DecimalFormat("#.00");
//        System.out.print(item.toString());
//        pwd();
        jitaNameSearch("三钛");
    }

    public static void dateTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,0,1,24,59,59);
        calendar.getTime();
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(sdf.format(DateUtil.getFirstTimeOfMonth(2017,7)));
        System.out.println(sdf.format(DateUtil.getLastTimeOfMonth(2017,7)));
        try {
            sdf.parse("2017-09-08 12:21:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void getUUID(){
        System.out.println(SysUtil.longUUID());
    }
    public static void testSplit(){
        String str = "12341245|3423453|3242342";
        String[] temp = str.split("\\|");
        System.out.println(SysUtil.createGson().toJson(temp));
    }
    public static void pwd(){
        String name = "";
        String password = "";
        try {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String reg_pwd_encode = base64en.encode(md5.digest((password + name).getBytes("utf-8")));
        System.out.println(reg_pwd_encode);
        } catch (Exception e) {
            System.out.println("转码失败");
        }
    }
    public static void jitaNameSearch(String name){
        final String JITA_SEARCH_NAME_URL = "https://www.ceve-market.org/api/searchname";

        Map<String,String> searchItem = new HashMap<String, String>();
        searchItem.put("name",name);
        String result = NetUtil.createNetConnection(JITA_SEARCH_NAME_URL, "POST", SysUtil.createGson().toJson(searchItem));
        System.out.println(result);
    }
}
