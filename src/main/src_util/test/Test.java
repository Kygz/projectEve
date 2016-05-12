package test;

import po.JitaItem;
import util.JitaUtil;

/**
 * Created by gavin on 2016/5/11 0011.
 */
public class Test {
    public static void main(String[] args) {
        JitaItem item = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("有毒金属"));
    }
}
