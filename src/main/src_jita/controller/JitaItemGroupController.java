package controller;

import manager.JitaManager;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.ItemPo;
import po.JitaGroupPo;
import po.JitaItem;
import po.MemberPo;
import util.StringUtil;
import util.SysUtil;
import vo.JitaGroupVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 吉他价格展板controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("itemGroup.do")
public class JitaItemGroupController {

    @Autowired
    private JitaManager jitaManager;

    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView showGroupIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            Long userId = memberPo.getMember_id();

            List<JitaGroupPo> jitaGroupPos = jitaManager.queryJitaGroupsByUserId(userId);
            List<JitaGroupVo> showSectionList = new ArrayList<>();

            if(StringUtil.isNotEmpty(jitaGroupPos)){
                jitaGroupPos.forEach(jitaGroupPo -> {
                    List<Map<String,String>> itemObjList = SysUtil.createGson().fromJson(jitaGroupPo.getItemList(),List.class);
                    List<Map<String,String>> itemObjListCopy = new ArrayList<>(itemObjList);
                    int i = 0;
                    Double titlePrice = 0D;
                    Double totalPrice = 0D;
                    boolean needCount = jitaGroupPo.getNeedCount();
                    boolean needCompare = jitaGroupPo.getShowType() == 1;
                    for (Map<String, String> itemObj : itemObjListCopy) {
                        String itemId = itemObj.get("id");
                        int itemNum = NumberUtils.toInt(itemObj.get("num"),1);
                        if(needCompare || needCount){
                            itemObj.put("name", itemObj.get("name") + " * " + itemNum);
                        }
                        JitaItem jitaItem = jitaManager.queryJitaItemPriceById(itemId);
                        if(jitaItem != null){
                            double buyHigh = jitaItem.getBuy().get("max");
                            if(needCompare && i == 0){
                                buyHigh = buyHigh * itemNum;
                                titlePrice = buyHigh;
                            }else if(needCompare || needCount){
                                buyHigh = buyHigh * itemNum;
                                totalPrice += buyHigh;
                            }
                            itemObj.put("price", String.format("%.2f", buyHigh));
                        }else{
                            itemObj.put("price", "0.00");
                        }
                        i++;
                    }

                    if(needCompare){
                        Map<String,String> compare = new HashMap<>();
                        compare.put("id","-1");
                        compare.put("name", titlePrice.compareTo(totalPrice) + "");
                        itemObjListCopy.add(compare);
                    }
                    if(needCount){
                        Map<String,String> total = new HashMap<>();
                        total.put("id","-2");
                        total.put("name", String.format("%.2f", totalPrice));
                        itemObjListCopy.add(total);
                    }
                    showSectionList.add(new JitaGroupVo(jitaGroupPo.getId().toString(),jitaGroupPo.getGroupName(),itemObjListCopy));
                });
            }
            ModelAndView modelAndView = new ModelAndView("jitaGroup/jitaGroupIndex");
            modelAndView.addObject("sections",showSectionList);
            return modelAndView;
        }
    }

    @RequestMapping(params = "method=addNewSection", method=RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addNewSection(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Map<String,String> result = new HashMap<>();
        MemberPo memberPo = (MemberPo)session.getAttribute("member");
        if(memberPo==null){
            result.put("code","-1");
            result.put("msg","掉线！请重新登录 try again!");
        }

        Long userId = memberPo.getMember_id();
        String title = request.getParameter("title");
        String needCompare = request.getParameter("needCompare");
        String needCount = request.getParameter("needCount");
        String itemList = request.getParameter("itemList");
        try{
            List<Map<String,String>> itemObjList = SysUtil.createGson().fromJson(itemList,List.class);
            itemObjList.forEach(obj -> {
                String id = obj.get("id");
                Integer num = NumberUtils.toInt(obj.get("num"), 1);
                obj.put("num", num.toString());
                ItemPo itemPo = jitaManager.queryJitaItemById(Long.parseLong(id));
                if(itemPo != null){
                    obj.put("name",itemPo.getItem_name());
                }else{
                    obj.put("name",id);
                }
            });

            JitaGroupPo jitaGroupPo = new JitaGroupPo();
            jitaGroupPo.setId(SysUtil.longUUID());
            jitaGroupPo.setUserId(userId);
            jitaGroupPo.setGroupName(title);
            jitaGroupPo.setNeedCount("true".equals(needCount));
            jitaGroupPo.setShowType("true".equals(needCompare)?1:0);
            jitaGroupPo.setItemList(SysUtil.createGson().toJson(itemObjList));
            jitaGroupPo.setCreateDate(new Date());
            jitaManager.saveJitaGroup(jitaGroupPo);
            result.put("code","0");
            result.put("msg","保存成功");
        }catch (Exception e){
            result.put("code","-1");
            result.put("msg","保存出错！请联系You Know Who");
        }

        return SysUtil.createGson().toJson(result);
    }
}
