package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import po.MemberPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import manager.MemberManager;
import sun.misc.BASE64Encoder;
import util.SysUtil;

/**
 * 用户登陆controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("member.do")
public class MemberController {
	private static Logger log = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberManager memberManager;

	/**
	 * 查成员当月总产
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "method=welcomeToMI", method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String welcomeToMI(HttpSession session,HttpServletRequest request){
		Map<String,String> resultMap = new HashMap<String, String>();
		String reg_name = request.getParameter("reg_name");
		String reg_nickName = request.getParameter("reg_nickName");
		String reg_pwd = request.getParameter("reg_pwd");
		String reg_pwd1 = request.getParameter("reg_pwd1");
		String reg_qq = request.getParameter("reg_qq");
		String reg_mail = request.getParameter("reg_mail");

		String reg_pwd_encode = "";
		try {
			MessageDigest md5= MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			reg_pwd_encode = base64en.encode(md5.digest((reg_pwd + reg_name).getBytes("utf-8")));
		} catch (Exception e) {
			log.info("转码失败",e);
		}
		MemberPo memberPo = new MemberPo();
		memberPo.setIdIfNew();
		memberPo.setMember_name(reg_name);
		memberPo.setMember_nickname(reg_nickName);
		memberPo.setMember_password(reg_pwd_encode);
		memberPo.setMember_qq(reg_qq);
		memberPo.setMember_email(reg_mail);
		String rv = memberManager.saveMember(memberPo);
		if("sameName".equals(rv)){
			resultMap.put("result","error");
			resultMap.put("msg","重名！");
		}else{
			resultMap.put("result","success");
			resultMap.put("msg","注册成功！");
		}
		return SysUtil.createGson().toJson(resultMap);
	}
}
