package planet;

import com.google.gson.Gson;
import po.PlanetPo;
import util.SysUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * 行星产物上交列表
 * Created by gavin on 2016/5/13 0013.
 */
public class PlanetTableTag extends TagSupport {
    private String jsonStr;
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = this.pageContext.getOut();
        try {
            Gson gson = SysUtil.createGson();
            List<PlanetPo> planetPoList = (List<PlanetPo>) gson.fromJson(jsonStr, Object.class);
            int i = 1;
            for(PlanetPo planetPo : planetPoList){
                out.println("<tr>" +
                        "<td>"+ i++ +"</td>" +
                        "<th>"+ planetPo.getPlanet_star1() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star2() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star3() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star4() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star5() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star6() + "</th>" +
                        "<th>"+ planetPo.getPlanet_star7() + "</th>" +
                        "<td>data</td>" +
                        "<td>10000isk</td>" +
                        "</tr>");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
    }
}
