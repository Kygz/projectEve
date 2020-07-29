package controller;

import manager.JitaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.ItemPo;
import po.JitaGroupPo;
import po.MemberPo;
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
            return new ModelAndView("jitaGroup/jitaGroupIndex");
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
            JitaGroupPo jitaGroupPo = new JitaGroupPo();
            jitaGroupPo.setId(SysUtil.longUUID());
            jitaGroupPo.setUserId(userId);
            jitaGroupPo.setGroupName(title);
            jitaGroupPo.setNeedCount("true".equals(needCount));
            jitaGroupPo.setShowType("true".equals(needCompare)?1:0);
            jitaGroupPo.setItemList(itemList);
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
