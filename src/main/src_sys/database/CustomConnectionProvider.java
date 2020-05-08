package database;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.Environment;
import util.DESUtil;
import util.StringUtil;

import java.util.Map;

public class CustomConnectionProvider extends C3P0ConnectionProvider {
    private static Logger log = Logger.getLogger(CustomConnectionProvider.class);

    public CustomConnectionProvider(){
        super();
    }

    @Override
    public void configure(Map props) {
        String user = (String)props.get(Environment.USER);
        String password = (String)props.get(Environment.PASS);
        if(StringUtil.isBlank(user)){
            throw new HibernateException("数据库帐号不能为空！");
        }
        if(StringUtil.isBlank(password)){
            throw new HibernateException("数据库密码不能为空！");
        }
        //解密
        props.put(Environment.USER, DESUtil.getDecryptString(user));
        props.put(Environment.PASS, DESUtil.getDecryptString(password));
        super.configure(props);

    }
}
