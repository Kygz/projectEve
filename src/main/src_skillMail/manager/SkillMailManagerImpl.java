package manager;

import dao.SkillDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import po.MailPo;
import util.SysUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

@Service
public class SkillMailManagerImpl implements SkillMailManager,ApplicationListener{
    @Resource
    private SkillDao skillDao;
    private static Logger log = Logger.getLogger(SkillMailManagerImpl.class);
    //定时任务集合
    private static Map<Long,Timer> timeLine = null;
    //初始化是否执行过
    private static boolean isStart = false;

    /**
     * 定时任务启动恢复
     * @param applicationEvent
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (!isStart) {//这个可以解决项目启动加载两次的问题
            isStart= true;
            log.info("TimeLine 启动！");
            List<MailPo> mailPos = skillDao.queryAllSkillMailsByDone(0);
            for(MailPo mailPo : mailPos){
                startTimeLine(mailPo);
            }
            //TODO 定时任务，项目启动时执行
        }
    }

    public List<MailPo> querySkillMailsByMemberId(Long memberId) {
        List<MailPo> mailPos = skillDao.querySkillMailsByMemberId(memberId);
        return mailPos;
    }

    public void insertSkillMail(MailPo mailPo) {
        skillDao.insertSkillMail(mailPo);
        log.info("加入定时任务");
        startTimeLine(mailPo);
    }

    public void deleteSkillMailBy(Long mailId) {
        skillDao.deleteSkillMailBy(mailId);
    }

    public void updateSkillMailState(Long mailId, Integer state) {
        MailPo mailPo = skillDao.querySkillMailByMailId(mailId);
        if(mailPo!=null){
            mailPo.setMail_done(state);
            skillDao.updateSkillMailState(mailPo);
            if(state!=0){
                this.endTimeLine(mailId);
            }
        }
    }

    public void startTimeLine(MailPo mail) {
        // 首次运行时间
        Date startTime = mail.getMail_time();
        if(startTime.getTime() < System.currentTimeMillis()){
            log.info(mail.getMail_id() + "申请时间已过期 跳过");
            updateSkillMailState(mail.getMail_id(),-2);
        }
        try{
            Timer t = new Timer();
            Long id = mail.getMail_id();
            MailTimeTask task = new MailTimeTask(id, mail.getMail_id(),mail.getMail_address(),mail.getMail_user_name(),mail.getMail_content(),this);

            t.schedule(task, startTime);
            if(timeLine==null){
                timeLine = new HashMap<Long, Timer>();
            }
            timeLine.put(id,t);
        }catch (Exception e){
            log.error(mail.getMail_id() + "加Timeline出现问题",e);
        }

    }

    private void endTimeLine(Long id){
        Timer timer = timeLine.get(id);
        log.info(id + " 结束定时任务");
        if(timer!=null){
            timer.cancel();
        }else {
            log.info(id + " 未找到定时任务");
        }
        timeLine.remove(id);
    }
}
