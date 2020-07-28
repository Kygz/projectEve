package controller;

import com.google.gson.Gson;
import manager.JitaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.ItemPo;
import po.JitaItem;
import util.JitaUtil;
import util.StringUtil;
import util.SysUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登陆controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("item.do")
public class JitaController {
    @Autowired
    private JitaManager jitaManager;

    @RequestMapping(params = "method=queryJitaPrice", method=RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryJitaPrice(HttpSession session,HttpServletRequest request,HttpServletResponse response){
        String itemName = request.getParameter("itemName");
        System.out.println("物品名：" + itemName);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");

        List<ItemPo> itemPoList = jitaManager.queryJitaItemNameListByName(itemName);
        if(itemPoList!=null&&itemPoList.size()==1){
            JitaItem jitaItem = JitaUtil.getItemInfo(itemPoList.get(0).getItem_id().toString());
            itemPoList.get(0).setItem_sell(jitaItem.getSell().toString());
            itemPoList.get(0).setItem_order(jitaItem.getBuy().toString());
            resultMap.put("state","1");
            resultMap.put("result",itemPoList.get(0));
            resultMap.put("sellHigh",df.format(jitaItem.getSell().get("max")));
            resultMap.put("sellLow",df.format(jitaItem.getSell().get("min")));
            resultMap.put("buyHigh",df.format(jitaItem.getBuy().get("max")));
            resultMap.put("buyLow",df.format(jitaItem.getBuy().get("min")));
            String json = SysUtil.createGson().toJson(resultMap);
            return json;
        }else if(itemPoList!=null&&itemPoList.size()>1){
            String msg = "";
            for(ItemPo po:itemPoList){
                msg += po.getItem_name() + "  ";
                if(po.getItem_name().equals(itemName)){
                    JitaItem jitaItem = JitaUtil.getItemInfo(po.getItem_id().toString());
                    po.setItem_sell(jitaItem.getSell().toString());
                    po.setItem_order(jitaItem.getBuy().toString());
                    resultMap.put("state","1");
                    resultMap.put("result",po);
                    resultMap.put("sellHigh",df.format(jitaItem.getSell().get("max")));
                    resultMap.put("sellLow",df.format(jitaItem.getSell().get("min")));
                    resultMap.put("buyHigh",df.format(jitaItem.getBuy().get("max")));
                    resultMap.put("buyLow",df.format(jitaItem.getBuy().get("min")));
                    Gson gson = new Gson();
                    return gson.toJson(resultMap);
                }
            }
            resultMap.put("state","2");
            resultMap.put("result",msg);

            String json = SysUtil.createGson().toJson(resultMap);
            return json;
        }else{
            resultMap.put("state","0");
            String json = SysUtil.createGson().toJson(resultMap);
            return json;
        }
    }

    @RequestMapping(params = "method=queryJitaMineralPrices", method=RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryJitaMineralPrices(HttpSession session,HttpServletRequest request,HttpServletResponse response){
        List<Map<String, String>> jitaMineralPrice = JitaUtil.getJitaMineralPrice();
        return SysUtil.createGson().toJson(jitaMineralPrice);
    }

    @RequestMapping(params = "method=queryJitaItemsByName", method=RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryJitaItemsByName(HttpSession session,HttpServletRequest request,HttpServletResponse response){
        List<Map<String,String>> result = new ArrayList<>();
        String itemName = request.getParameter("itemName");
        if(StringUtil.isBlank(itemName)) {
            List<ItemPo> itemPos = jitaManager.queryJitaItemNameListByName(itemName);
            if(StringUtil.isNotEmpty(itemPos)){
                itemPos.forEach(itemPo -> {
                    Map<String,String> tempMap = new HashMap<>();
                    tempMap.put("id",itemPo.getItem_id().toString());
                    tempMap.put("name",itemPo.getItem_name());
                    result.add(tempMap);
                });
            }
        }
        return SysUtil.createGson().toJson(result);
    }
}
