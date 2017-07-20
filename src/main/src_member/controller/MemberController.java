package controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("member.do")
public class MemberController {
	@Autowired
	private MemberManager memberManager;
}
