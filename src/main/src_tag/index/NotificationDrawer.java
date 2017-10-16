package index;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 首页侧栏六维
 * Created by gavin on 2016/4/29 0029.
 */
public class NotificationDrawer extends TagSupport {

    @Override
    public int doStartTag() throws JspException{
        JspWriter out = this.pageContext.getOut();
        try {
            out.println("<div id=\"notifications\" class=\"tile drawer animated\">");
            out.println("   <div class=\"listview narrow\">");
            out.println("       <div class=\"media\">");
            out.println("       	<a href=\"\">Send a New Message</a> <span class=\"drawer-close\">&times;</span>");
            out.println("       </div>");
            out.println("       <div class=\"overflow\" style=\"height: 254px\">");

            for(int i = 0;i<1;i++){
                out.println("           <div class=\"media\">");
                out.println("           	<div class=\"pull-left\">");
                out.println("           		<img width=\"40\" src=\"img/profile-pics/1.jpg\" alt=\"\">");
                out.println("           	</div>");
                out.println("           	<div class=\"media-body\">");
                out.println("           		<small class=\"text-muted\">Nadin Jackson - 2 Hours ago</small><br>");
                out.println("           		<a class=\"t-overflow\" href=\"\"> 待建设 </a>");
                out.println("           	</div>");
                out.println("           </div>");
            }

            out.println("       </div>");
            out.println("       </div>");
            out.println("       <div class=\"media text-center whiter l-100\">");
            out.println("       	<a href=\"\"><small>VIEW ALL</small></a>");
            out.println("       </div>");
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
    }
}
