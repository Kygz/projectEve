package po;

import util.SysUtil;

import java.util.Date;

public class CalendarJoinPo {
    private Long calendar_join_id;
    private Long calendar_event_id;
    private Long calendar_member_id;
    private String calendar_member_name;

    public Long getCalendar_join_id() {
        return calendar_join_id;
    }

    public void setCalendar_join_id(Long calendar_join_id) {
        this.calendar_join_id = calendar_join_id;
    }

    public Long getCalendar_event_id() {
        return calendar_event_id;
    }

    public void setCalendar_event_id(Long calendar_event_id) {
        this.calendar_event_id = calendar_event_id;
    }

    public Long getCalendar_member_id() {
        return calendar_member_id;
    }

    public void setCalendar_member_id(Long calendar_member_id) {
        this.calendar_member_id = calendar_member_id;
    }

    public String getCalendar_member_name() {
        return calendar_member_name;
    }

    public void setCalendar_member_name(String calendar_member_name) {
        this.calendar_member_name = calendar_member_name;
    }

    public void setIdIfNew() {
        this.setCalendar_join_id(SysUtil.longUUID());
    }
}
