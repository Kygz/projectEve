package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import po.MemberPo;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("shipAssembly.do")
public class shipAssemblyController {

    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView shipAssemblyIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("shipAssembly/form-shipAssembly");
        }
    }

    @RequestMapping(params = "method=list", method= RequestMethod.GET)
    public ModelAndView shipAssemblyListIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            return new ModelAndView("shipAssembly/form-shipAssembly");
        }
    }

    public String insertShipAssembly(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
        }else{
        }
        return null;
    }
}
