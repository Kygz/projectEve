package controller;

import manager.JitaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import po.JitaGroupPo;
import po.MemberPo;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 吉他价格展板controller
 * @author KYGZ XXOO
 *
 */
@Controller
@RequestMapping("itemGroup.do")
public class JitaItemGroupController {

    @Autowired
    private JitaManager jitaManager;

    @RequestMapping(params = "method=index", method= RequestMethod.GET)
    public ModelAndView showGroupIndex(HttpSession httpSession){
        MemberPo memberPo = (MemberPo)httpSession.getAttribute("member");
        if(memberPo==null){
            return new ModelAndView("login");
        }else{
            Long userId = memberPo.getMember_id();

            List<JitaGroupPo> jitaGroupPos = jitaManager.queryJitaGroupsByUserId(userId);
            return new ModelAndView("jitaGroup/jitaGroupIndex");
        }
    }
}
