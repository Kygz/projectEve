package manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TimelineManagerImpl implements TimelineManager,ApplicationListener {
    private static Log log = LogFactory.getLog(TimelineManagerImpl.class);

    private static boolean isStart = false;
    /**
     * 定时任务启动恢复
     * @param applicationEvent
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (!isStart) {//这个可以解决项目启动加载两次的问题
            isStart= true;
            log.info("TimeLine 启动！");
            //TODO 定时任务，项目启动时执行
        }
    }

    public void startTimeLine(Long time) {
        if(time < System.currentTimeMillis()){
            log.info("申请时间已过期 跳过");
        }
        try{
            // 首次运行时间
            Date startTime = new Date(time);

//            // 如果今天的已经过了 首次运行时间就改为明天
//            if(System.currentTimeMillis() > startTime.getTime())
//                startTime = new Date(startTime.getTime() + daySpan);

            Timer t = new Timer();

            TimerTask task = new TimerTask(){
                @Override
                public void run() {
                    // 要执行的代码
                    System.err.println("xxxxxxxxx");
                }
            };

            t.schedule(task, startTime);
        }catch (Exception e){

        }

    }

    public void startTimeLine() {

    }
}
