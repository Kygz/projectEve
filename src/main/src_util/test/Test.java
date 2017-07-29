package test;

import po.JitaItem;
import util.DateUtil;
import util.JitaUtil;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class Test {
    public static void main(String[] args) {
//        JitaItem item = JitaUtil.getItemInfo("34");
//        DecimalFormat df =new   java.text.DecimalFormat("#.00");
//        System.out.print(item.toString());
        dateTest();
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

}
