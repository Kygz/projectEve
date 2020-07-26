package po;

import java.util.Date;

/**
 * 对应jita_group_user表中实体
 */
public class JitaGroupPo {
    private Long id;
    private Long userId;
    private String groupName;
    private Integer showType;
    private String itemList;
    private Boolean needCount;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public Boolean getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Boolean needCount) {
        this.needCount = needCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
