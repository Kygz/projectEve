package controller;

import com.google.gson.Gson;
import manager.PlanetManager;
import manager.SkillMailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.JitaItem;
import po.MailPo;
import po.MemberPo;
import po.PlanetPo;
import po.PlanetRecordResult;
import util.JitaUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("skillMail.do")
public class SkillMailController {
	@Autowired
	private SkillMailManager skillMailManager;
	
	/**
	 * 查询所有提醒
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=queryMail", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryMonth(HttpSession session){
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		List<MailPo> mailPos = new ArrayList<MailPo>();
		if(memberPo!=null) {
			mailPos = skillMailManager.querySkillMailsByMemberId(memberPo.getMember_id());
		}
		Gson gson = new Gson();
		return gson.toJson(mailPos);
	}

	/**
	 * 增加邮件提醒
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=insertMail", method=RequestMethod.POST, produces="plain/html;charset=UTF-8")
	@ResponseBody
	public String insertMail(HttpSession session,HttpServletRequest request,HttpServletResponse response){
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

	@RequestMapping(params = "method=index", method=RequestMethod.GET)
	public ModelAndView mailIndex(HttpSession httpSession){
		MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
		if(memberPo==null){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("skillMail/form-skillMail");
		}
	}
}
