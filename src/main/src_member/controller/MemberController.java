package controller;

import java.io.UnsupportedEncodingException;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.MemberPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import manager.MemberManager;

/**
 * 用户登陆controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("login.do")
public class MemberController {
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
}
