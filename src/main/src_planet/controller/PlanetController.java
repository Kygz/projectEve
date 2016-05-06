package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import org.springframework.web.servlet.ModelAndView;
import po.MemberPo;
import po.PlanetPo;
import po.PlanetRecordResult;
import manager.PlanetManager;

import java.util.Date;

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
	@RequestMapping(params = "method=queryMonth", method=RequestMethod.POST)
	@ResponseBody
	public String queryMonth(HttpSession session){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		String userId = memberPo.getMember_id().toString();
		String username = memberPo.getMember_name();
		PlanetRecordResult pr = planetManager.queryPlanetRecordByMemeberPerMonth(userId,username);
		Gson gson = new Gson();
		String json = gson.toJson(pr);
		return json;
	}
	/**
	 * 提交行星产物
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=insertPlanetRecord", method=RequestMethod.POST)
	@ResponseBody
	public String insertPlanetRecord(HttpSession session,HttpServletRequest request){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
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
		planetManager.insertPlanetRecordById(planetPo);
		return "";
	}
	@RequestMapping(params = "method=planetInsertPage", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession httpSession){
		MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
		if(memberPo==null){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("form-planets");
		}
	}
}
