package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import org.springframework.web.servlet.ModelAndView;
import po.JitaItem;
import po.MemberPo;
import po.PlanetPo;
import po.PlanetRecordResult;
import manager.PlanetManager;
import util.JitaUtil;
import util.SysUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("planet.do")
public class PlanetController {
	@Autowired
	private PlanetManager planetManager;
	
	/**
	 * 查成员当月总产
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=queryMonth", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryMonth(HttpSession session){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		String userId = memberPo.getMember_id().toString();
		String username = memberPo.getMember_name();
		PlanetRecordResult pr = planetManager.queryPlanetRecordByMemeberPerMonth(userId,username);
		return SysUtil.createGson().toJson(pr);
	}
	/**
	 * 提交行星产物
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=insertPlanetRecord", method=RequestMethod.POST, produces="plain/html;charset=UTF-8")
	@ResponseBody
	public String insertPlanetRecord(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		Map<String,String> resultMap = new HashMap<String, String>();
		if(memberPo==null) {
			resultMap.put("result","false");
			resultMap.put("msg","妖兽啊~~掉线啦~~~");

		}else{
			String planet1 = request.getParameter("planet1");
			String planet2 = request.getParameter("planet2");
			String planet3 = request.getParameter("planet3");
			String planet4 = request.getParameter("planet4");
			String planet5 = request.getParameter("planet5");
			String planet6 = request.getParameter("planet6");
			String planet7 = request.getParameter("planet7");

			PlanetPo planetPo = new PlanetPo();
			planetPo.setIdIfNew();
			planetPo.setPlanet_user_id(memberPo.getMember_id().toString());
			planetPo.setPlanet_user_name(memberPo.getMember_nickname());
			planetPo.setPlanet_update_date(new Date());
			planetPo.setPlanet_star1(Long.parseLong(planet1));
			planetPo.setPlanet_star2(Long.parseLong(planet2));
			planetPo.setPlanet_star3(Long.parseLong(planet3));
			planetPo.setPlanet_star4(Long.parseLong(planet4));
			planetPo.setPlanet_star5(Long.parseLong(planet5));
			planetPo.setPlanet_star6(Long.parseLong(planet6));
			planetPo.setPlanet_star7(Long.parseLong(planet7));

			JitaItem item1 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("氧"));
			JitaItem item2 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("电解物"));
			JitaItem item3 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("水"));
			JitaItem item4 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("稀有金属"));
			JitaItem item5 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("有毒金属"));
			JitaItem item6 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("反应金属"));
			JitaItem item7 = JitaUtil.getItemInfo(JitaUtil.getP1IdbyName("手性结构"));

			planetPo.setPlanet_star1_price(item1 != null ? item1.getSell().get("max") : 0);
			planetPo.setPlanet_star2_price(item2 != null ? item2.getSell().get("max") : 0);
			planetPo.setPlanet_star3_price(item3 != null ? item3.getSell().get("max") : 0);
			planetPo.setPlanet_star4_price(item4 != null ? item4.getSell().get("max") : 0);
			planetPo.setPlanet_star5_price(item5 != null ? item5.getSell().get("max") : 0);
			planetPo.setPlanet_star6_price(item6 != null ? item6.getSell().get("max") : 0);
			planetPo.setPlanet_star7_price(item7 != null ? item7.getSell().get("max") : 0);
			planetManager.insertPlanetRecordById(planetPo);

			double price = 0.8 * item1.getSell().get("max") * Long.parseLong(planet1) +
					item2.getSell().get("max") * Long.parseLong(planet2) +
					item3.getSell().get("max") * Long.parseLong(planet3) +
					item4.getSell().get("max") * Long.parseLong(planet4) +
					item5.getSell().get("max") * Long.parseLong(planet5) +
					item6.getSell().get("max") * Long.parseLong(planet6) +
					item7.getSell().get("max") * Long.parseLong(planet7);

			String msg = "<p>"+"提交成功！" + "</p>" +
					"<p>"+"今日吉他姬提供参考价格如下" + "</p>" +
					"<p>"+"氧——" + item1.getSell().get("max") + "</p>" +
					"<p>"+"电解物——" + item2.getSell().get("max") + "</p>" +
					"<p>"+"水——" + item3.getSell().get("max") + "</p>" +
					"<p>"+"稀有金属——" + item4.getSell().get("max") + "</p>" +
					"<p>"+"有毒金属——" + item5.getSell().get("max") + "</p>" +
					"<p>"+"反应金属——" + item6.getSell().get("max") + "</p>" +
					"<p>"+"手性结构——" + item7.getSell().get("max") + "</p>" +
					"<p>"+"总价为：" + String .format("%.2f",price) + "isk" + "</p>";
			resultMap.put("result","true");
			resultMap.put("msg",msg);
		}
		return SysUtil.createGson().toJson(resultMap);
	}

	/**
	 * 查成员最新五条提交记录
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=queryFive", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryFive(HttpSession session){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		String userId = memberPo.getMember_id().toString();
		List<PlanetPo> planetPoList = planetManager.queryPlanetPoFiveByUserId(userId);
		return SysUtil.createGson().toJson(planetPoList);
	}

	@RequestMapping(params = "method=planetInsertPage", method=RequestMethod.GET)
	public ModelAndView planetInsertPage(HttpSession httpSession){
		MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
		if(memberPo==null){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("planet/form-planets");
		}
	}
}
