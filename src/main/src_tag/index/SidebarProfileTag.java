package index;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 首页侧栏个人信息
 * Created by gavin on 2016/6/30.
 */
public class SidebarProfileTag extends TagSupport {
    private String userName;
    private String qqNum;

    @Override
    public int doStartTag() throws JspException{
        JspWriter out = this.pageContext.getOut();
        try {
            out.println("<div class=\"text-center s-widget m-b-25 dropdown\" id=\"profile-menu\">" +
                        "	<a href=\"\" data-toggle=\"dropdown\">" +
                        "       <img class=\"profile-pic animated\" src=\"img/profile-picNew.jpg\" alt=\"\">" +
                        "	</a>" +
                        "	<ul class=\"dropdown-menu profile-menu\">" +
                        "		<li>" +
                        "           <a href=\"\">舰长信息</a>" +
                        "           <i class=\"icon left\">&#61903;</i>" +
                        "           <i class=\"icon right\">&#61815;</i>" +
                        "       </li>" +
                        "		<li>" +
                        "           <a href=\"login.do?method=logout\">离开太空</a>" +
                        "           <i class=\"icon left\">&#61903;</i>" +
                        "           <i class=\"icon right\">&#61815;</i>" +
                        "       </li>" +
                        "	</ul>" +
                        "	<h4 class=\"m-0\">"+ userName +"</h4>" +
                        "	#" + qqNum +
                        "</div>");
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
        this.userName = "";
        this.qqNum = "";

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }
}

