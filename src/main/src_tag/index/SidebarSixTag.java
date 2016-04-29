package index;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 首页侧栏六维
 * Created by gavin on 2016/4/29 0029.
 */
public class SidebarSixTag  extends TagSupport {
    private int para1;
    private int para2;
    private int para3;
    private int para4;
    private int para5;
    private int para6;
    @Override
    public int doStartTag() throws JspException{
        JspWriter out = this.pageContext.getOut();
        String[] theSix = {"歼灭姬","挖掘姬","种植姬","教官姬","保镖姬","富豪姬"};
        int[] theSixNum = {para1,para2,para3,para4,para5,para6};
        String[] theColor = {"progress-bar-danger","progress-bar-info","progress-bar progress-bar-warning","progress-bar-danger","progress-bar-info","progress-bar progress-bar-warning"};
        try {
            out.println("<div class=\"s-widget m-b-25\">");
            out.println("   <h2 class=\"tile-title\">舰长六维</h2>");
            out.println("   <div class=\"s-widget-body\">");
            for(int i = 0;i<6;i++){
                out.println("       <div class=\"side-border\">");
                out.println("           <small>"+theSix[i]+"</small>");
                out.println("           <div class=\"progress progress-small\">");
                out.println("               <a title=\"\" class=\"progress-bar tooltips "+theColor[i]+"\" style=\"width: "+theSixNum[i]*10+"%;\" href=\"#\" data-original-title=\""+theSixNum[i]*10+"%\" data-toggle=\"tooltip\"> <span class=\"sr-only\">"+theSixNum[i]*10+"% Complete</span>");
                out.println("               </a>");
                out.println("           </div>");
                out.println("       </div>");
            }
            out.println("   </div>");
            out.println("</div>");
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
        this.para1 = 0;
        this.para2 = 0;
        this.para3 = 0;
        this.para4 = 0;
        this.para5 = 0;
        this.para6 = 0;
    }

    public int getPara1() {
        return para1;
    }

    public void setPara1(int para1) {
        this.para1 = para1;
    }

    public int getPara2() {
        return para2;
    }

    public void setPara2(int para2) {
        this.para2 = para2;
    }

    public int getPara3() {
        return para3;
    }

    public void setPara3(int para3) {
        this.para3 = para3;
    }

    public int getPara4() {
        return para4;
    }

    public void setPara4(int para4) {
        this.para4 = para4;
    }

    public int getPara5() {
        return para5;
    }

    public void setPara5(int para5) {
        this.para5 = para5;
    }

    public int getPara6() {
        return para6;
    }

    public void setPara6(int para6) {
        this.para6 = para6;
    }
}
