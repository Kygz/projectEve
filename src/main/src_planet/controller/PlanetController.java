package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import po.MemberPo;
import po.PlanetRecordResult;
import manager.PlanetManager;

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
	public String insertPlanetRecord(HttpSession session){
		String username = (String)session.getAttribute("username");
		Long planet1 = (Long)session.getAttribute("planet1");
		Long planet2 = (Long)session.getAttribute("planet2");
		Long planet3 = (Long)session.getAttribute("planet3");
		Long planet4 = (Long)session.getAttribute("planet4");
		Long planet5 = (Long)session.getAttribute("planet5");
		Long planet6 = (Long)session.getAttribute("planet6");
		Long planet7 = (Long)session.getAttribute("planet7");
		
		return null;
	}
}
