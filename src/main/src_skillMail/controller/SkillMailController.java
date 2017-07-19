package controller;

import com.google.gson.Gson;
import manager.PlanetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.JitaItem;
import po.MemberPo;
import po.PlanetPo;
import po.PlanetRecordResult;
import util.JitaUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/skillMail")
public class SkillMailController {
	@Autowired
	private PlanetManager planetManager;
	
	/**
	 * 查询所有生效中的提醒
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "/queryAlert", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryMonth(HttpSession session){
		String pr = "";
		Gson gson = new Gson();
		return gson.toJson(pr);
	}

	/**
	 * 增加邮件提醒
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "/insertMailAlert", method=RequestMethod.POST, produces="plain/html;charset=UTF-8")
	@ResponseBody
	public String insertPlanetRecord(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		Map<String,String> resultMap = new HashMap<String, String>();
		if(memberPo==null) {
			resultMap.put("result","false");
			resultMap.put("msg","妖兽啊~~掉线啦~~~");
		}else{
			resultMap.put("result","true");
			resultMap.put("msg","");
		}
		Gson gson = new Gson();
		String json = gson.toJson(resultMap);
		return json;
	}

	@RequestMapping(params = "/index", method=RequestMethod.GET)
	public ModelAndView mailIndex(HttpSession httpSession){
		MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
		if(memberPo==null){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("form-skillMail");
		}
	}
}
