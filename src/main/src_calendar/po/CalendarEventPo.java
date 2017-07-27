package po;

import util.SysUtil;

import java.util.Date;

public class CalendarEventPo {
    private Long calendar_id;
    private Long calendar_create_id;
    private String calendar_title;
    private String calendar_content;
    private Date calendar_startTime;
    private Date calendar_endTime;
    private int calendar_allDay;
    private int calendar_state;

    public Long getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(Long calendar_id) {
        this.calendar_id = calendar_id;
    }

    public Long getCalendar_create_id() {
        return calendar_create_id;
    }

    public void setCalendar_create_id(Long calendar_create_id) {
        this.calendar_create_id = calendar_create_id;
    }

    public String getCalendar_title() {
        return calendar_title;
    }

    public void setCalendar_title(String calendar_title) {
        this.calendar_title = calendar_title;
    }

    public String getCalendar_content() {
        return calendar_content;
    }

    public void setCalendar_content(String calendar_content) {
        this.calendar_content = calendar_content;
    }

    public Date getCalendar_startTime() {
        return calendar_startTime;
    }

    public void setCalendar_startTime(Date calendar_startTime) {
        this.calendar_startTime = calendar_startTime;
    }

    public Date getCalendar_endTime() {
        return calendar_endTime;
    }

    public void setCalendar_endTime(Date calendar_endTime) {
        this.calendar_endTime = calendar_endTime;
    }

    public int getCalendar_allDay() {
        return calendar_allDay;
    }

    public void setCalendar_allDay(int calendar_allDay) {
        this.calendar_allDay = calendar_allDay;
    }

    public int getCalendar_state() {
        return calendar_state;
    }

    public void setCalendar_state(int calendar_state) {
        this.calendar_state = calendar_state;
    }

    public void setIdIfNew() {
        this.setCalendar_id(SysUtil.longUUID());
    }

}
