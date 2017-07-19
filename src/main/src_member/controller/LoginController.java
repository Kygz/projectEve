package controller;

import com.google.gson.Gson;
import manager.MemberManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.MemberPo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.http.Cookie;

/**
 * 用户登陆controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("login.do")
public class LoginController {
	@Autowired
	private MemberManager memberManager;
	
	@RequestMapping(params = "method=login", method=RequestMethod.POST)
    public ModelAndView login(@CookieValue(value = "hasAccount",required  = false) String hasAccount,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) throws UnsupportedEncodingException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		String isSave = request.getParameter("saveAccount");
//		if("on".equals(isSave)){
//			hasAccount = name;
//			Cookie cookie = new Cookie("hasAccount",hasAccount);
//			cookie.setMaxAge(60*60*24*7);//保留7天
//			response.addCookie(cookie);
//		}
		ModelAndView mav = new ModelAndView("login");
		if((name==null||"".equals(name))||(password==null||"".equals(password))){
			mav.addObject("error", "用户密码不能为空！");
			return mav;
		}

		MemberPo memberPo = memberManager.queryMemberByIdAndPassword(name, password);
		
		if(memberPo==null){
			mav.addObject("error", "帐号或密码错误！");
			return mav;
		}

		httpSession.setAttribute("member", memberPo);

		return new ModelAndView("index");  // 采用重定向方式跳转页面
        // 重定向还有一种简单写法
		//return new ModelAndView("redirect:projectEve/WEB-INF/pages/index.jsp");
    }
	
	@RequestMapping(params = "method=logout", method=RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession){
		httpSession.removeAttribute("member");
        return new ModelAndView("login");
    }

	/**
	 * 进入主页
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(params = "method=index", method=RequestMethod.GET)
	public ModelAndView index(HttpSession httpSession){
		return new ModelAndView("index");
	}

	@RequestMapping(params = "method=memberInfo", method=RequestMethod.GET)
    public ModelAndView memberInfo(HttpSession httpSession){
        return new ModelAndView("index");
    }

	@RequestMapping(params = "method=myGirl", method=RequestMethod.GET)
    public ModelAndView colorEgg(HttpSession httpSession){
        return new ModelAndView("myGirl");
    }

	/**
	 * 查成员当月总产
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=saveSkin", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveSkin(HttpSession session,HttpServletRequest request){
		Map<String,String> resultMap = new HashMap<String, String>();
		MemberPo memberPo = (MemberPo)session.getAttribute("member");
		String newSkin = request.getParameter("skin");
		if(memberPo!=null){
			if(newSkin!=null&&!"".equals(newSkin)){
				memberPo.setMember_skin(newSkin);
			}else{
				memberPo.setMember_skin("skin-blur-violate");
			}
			memberManager.saveSkinByMember(memberPo);
			resultMap.put("result","success");
			resultMap.put("msg","成功");
		}else{
			resultMap.put("result","false");
			resultMap.put("msg","妖兽啊~~掉线啦~~~");
		}
		Gson gson = new Gson();
		return gson.toJson(resultMap);
	}
}
