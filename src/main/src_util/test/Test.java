package test;

import po.JitaItem;
import util.JitaUtil;

import java.text.DecimalFormat;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class Test {
    public static void main(String[] args) {
        JitaItem item = JitaUtil.getItemInfo("34");
        DecimalFormat df =new   java.text.DecimalFormat("#.00");
        System.out.print(item.toString());
    }
}
