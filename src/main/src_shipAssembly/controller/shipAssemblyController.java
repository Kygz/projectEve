package controller;

import constants.RoleConstants;
import constants.ShipAssemblyConstants;
import manager.MemberManager;
import manager.RoleManager;
import manager.ShipAssemblyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.MemberPo;
import po.RolePo;
import po.ShipAssemblyPo;
import util.ShipAssemblyUtil;
import util.SysUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shipAssembly.do")
public class shipAssemblyController {
    @Autowired
    private MemberManager memberManager;
    @Autowired
    private RoleManager RoleManager;
    @Autowired
    private ShipAssemblyManager shipAssemblyManager;

    /**
     * 上传
     * @param httpSession
     * @return
     */
    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView shipAssemblyIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            Map<String, Long> shipMap = shipAssemblyManager.getShipMap();
            List<Map<String,String>> shipSelect = new ArrayList<>();
            shipMap.keySet().forEach(ship -> {
                Map<String,String> shipInfo = new HashMap<>();
                shipInfo.put("id",shipMap.get(ship).toString());
                shipInfo.put("name",ship);
                shipSelect.add(shipInfo);
            });
            ModelAndView modelAndView = new ModelAndView("shipAssembly/form-shipAssembly");
            modelAndView.addObject("shipList",shipSelect);
            return modelAndView;
        }
    }

    /**
     * 列表
     * @param httpSession
     * @return
     */
    @RequestMapping(params = "method=list", method= RequestMethod.GET)
    public ModelAndView shipAssemblyListIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("shipAssembly/list-shipAssembly");
        }
    }

    @RequestMapping(params = "method=addShipAssembly", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String insertShipAssembly(HttpSession httpSession, HttpServletRequest request){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(memberPo==null){
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            RolePo rolePo = RoleManager.queryRoleByKey(RoleConstants.SHIP_ASSEMBLY_ADMIN);
            if(rolePo!=null||rolePo.getRoleIdList().contains(memberPo.getMember_id())){

                String title = request.getParameter("title");
                String img = request.getParameter("img");
                String content = request.getParameter("content");
                String shipInfo = request.getParameter("shipInfo");
                String c1 = request.getParameter("c1");
                String c2 = request.getParameter("c2");
                String c3 = request.getParameter("c3");
                String c4 = request.getParameter("c4");
                String ship_scope = request.getParameter("ship_scope");
                String ship_type = request.getParameter("ship_type");
                String ship_tag = request.getParameter("ship_tag");

                shipAssemblyManager.getItemsFromText("","","","","");

                ShipAssemblyPo po = new ShipAssemblyPo();
                po.setIdIfNew();
                po.setShipAssembly_creator_id(memberPo.getMember_id());
                po.setShipAssembly_creator_name(memberPo.getMember_nickname());
                po.setShipAssembly_create_time(new Date());
                po.setShipAssembly_title(title);
                po.setShipAssembly_img(img);
                po.setShipAssembly_content(content);
                po.setShipAssembly_scope(Integer.parseInt(ship_scope));
                po.setShipAssembly_ship_type(Integer.parseInt(ship_type));
                po.setShipAssembly_tag(ship_tag);

                shipAssemblyManager.insertShipAssemblyPo(po);

                resultMap.put("result","true");
                resultMap.put("msg","成功");
            }else {
                resultMap.put("result","false");
                resultMap.put("msg","无权限！");
            }
        }
        return SysUtil.createGson().toJson(resultMap);
    }

    @RequestMapping(params = "method=queryList", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String queryShipAssembly(HttpSession httpSession, HttpServletRequest request){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(memberPo==null){
            resultMap.put("result","false");
            resultMap.put("msg","妖兽啊~~掉线啦~~~");
        }else{
            String pageNo = request.getParameter("pageNo");
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("pageNo",Integer.parseInt(pageNo));
            List<ShipAssemblyPo> shipAssemblyPos = shipAssemblyManager.queryShipAssemblyPo(param);
            for(ShipAssemblyPo po: shipAssemblyPos){
                po.setShipAssembly_img("");
            }
            resultMap.put("result","true");
            resultMap.put("msg","成功");
            resultMap.put("list",shipAssemblyPos);
        }
        return SysUtil.createGson().toJson(resultMap);
    }

    @RequestMapping(params = "method=getPic", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getPic(HttpSession httpSession, HttpServletRequest request){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        String id = request.getParameter("id");
        Map<String,Object> param = new HashMap<String,Object>();
        ShipAssemblyPo shipAssemblyPo = shipAssemblyManager.queryShipAssemblyPoById(Long.parseLong(id));
        resultMap.put("result","true");
        resultMap.put("msg","成功");
        resultMap.put("img",shipAssemblyPo.getShipAssembly_img());
        return SysUtil.createGson().toJson(resultMap);
    }
}
