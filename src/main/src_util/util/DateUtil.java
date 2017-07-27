package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间相关工具
 * @author kygz
 *
 */
public class DateUtil {
	/**
	 * 拿当月最后一天
	 * @param sDate1
	 * @return
	 */
	public static String getLastDayOfMonth(Date sDate1) { 
		 Calendar cDay1 = Calendar.getInstance(); 
		 cDay1.setTime(sDate1); 
		 final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		 Date lastDate = cDay1.getTime(); 
		 lastDate.setDate(lastDay); 
		 SimpleDateFormat dateStyle=new SimpleDateFormat("yyyyMMdd");
		 return dateStyle.format(lastDate);
	} 
	/**
	 * 拿当月第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(Date date){
		SimpleDateFormat dateStyle=new SimpleDateFormat("yyyyMM01");
		return dateStyle.format(date);
	}
	
	public static String getTimeBetweenTwoDays(Date before,Date after){
		Long beforeTime = before.getTime();
		Long afterTime = after.getTime();
		Long result = (afterTime - beforeTime)/1000;
		return result.toString();
	}

	/**
	 * 拿当月最后一天23点59分59秒，不续一秒
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastTimeOfMonth(int year,int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month-1,1,23,59,59);
		final int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year,month -1,lastDay);
		return calendar.getTime();
	}

	/**
	 * 拿当月第一天0点0时0分0秒
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstTimeOfMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month-1,1,0,0,0);
		return calendar.getTime();
	}
}
