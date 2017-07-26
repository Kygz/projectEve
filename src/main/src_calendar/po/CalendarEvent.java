package po;

import java.util.Date;

public class CalendarEvent {
    private Long calender_id;
    private Long calender_create_id;
    private String calendar_title;
    private Date calendar_startTime;
    private Date calendar_endTime;
    private int calendar_state;

    public Long getCalender_id() {
        return calender_id;
    }

    public void setCalender_id(Long calender_id) {
        this.calender_id = calender_id;
    }

    public Long getCalender_create_id() {
        return calender_create_id;
    }

    public void setCalender_create_id(Long calender_create_id) {
        this.calender_create_id = calender_create_id;
    }

    public String getCalendar_title() {
        return calendar_title;
    }

    public void setCalendar_title(String calendar_title) {
        this.calendar_title = calendar_title;
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
}
