package po;

import enumUtils.BlueprintEnum;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 工业制造蓝图Po
 */
public class BlueprintPo {
    private Long blueprintTypeId;
    private String blueprintTypeName;
    private LinkedHashMap<String,LinkedHashMap<String,Object>> activities;
    private Integer maxProductionLimit;
    //copying, invention, manufacturing, research_material, research_time;
    private Set<String> contentSet;

    public BlueprintPo(LinkedHashMap<String,Object> yamlObj) {
        this.blueprintTypeId = ((Integer) yamlObj.get("blueprintTypeID")).longValue();
        this.activities = (LinkedHashMap<String,LinkedHashMap<String,Object>>) yamlObj.get("activities");
        this.maxProductionLimit = (Integer) yamlObj.get("maxProductionLimit");
        this.contentSet = this.activities.keySet();
    }

    public Long getBlueprintTypeId() {
        return blueprintTypeId;
    }

    public void setBlueprintTypeId(Long blueprintTypeId) {
        this.blueprintTypeId = blueprintTypeId;
    }

    public LinkedHashMap<String, LinkedHashMap<String, Object>> getActivities() {
        return activities;
    }

    public void setActivities(LinkedHashMap<String, LinkedHashMap<String, Object>> activities) {
        this.activities = activities;
    }

    public Integer getMaxProductionLimit() {
        return maxProductionLimit;
    }

    public void setMaxProductionLimit(Integer maxProductionLimit) {
        this.maxProductionLimit = maxProductionLimit;
    }

    public boolean isCanResearch() {
        return this.contentSet.contains(BlueprintEnum.research_material.getActivityType())
                && this.contentSet.contains(BlueprintEnum.research_time.getActivityType());
    }

    public boolean isCanInvent() {
        return this.contentSet.contains(BlueprintEnum.invention.getActivityType());
    }

    public boolean isCanManufacture() {
        return this.contentSet.contains(BlueprintEnum.manufacturing.getActivityType());
    }

    public boolean isCanCopy() {
        return this.contentSet.contains(BlueprintEnum.copying.getActivityType());
    }

    public String getBlueprintTypeName() {
        return blueprintTypeName;
    }

    public void setBlueprintTypeName(String blueprintTypeName) {
        this.blueprintTypeName = blueprintTypeName;
    }
}
