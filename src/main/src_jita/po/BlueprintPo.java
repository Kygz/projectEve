package po;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 工业制造蓝图Po
 */
public class BlueprintPo {
    private Integer blueprintTypeId;
    private LinkedHashMap<String,LinkedHashMap<String,Object>> activities;
    private Integer maxProductionLimit;
    //copying, invention, manufacturing, research_material, research_time;
    private Set<String> contentSet;



    public BlueprintPo(LinkedHashMap<String,Object> yamlObj) {
        this.blueprintTypeId = (Integer) yamlObj.get("blueprintTypeId");
        this.activities = (LinkedHashMap<String,LinkedHashMap<String,Object>>) yamlObj.get("activities");
        this.maxProductionLimit = (Integer) yamlObj.get("blueprintTypeId");
        this.contentSet = this.activities.keySet();

    }

    public Integer getBlueprintTypeId() {
        return blueprintTypeId;
    }

    public void setBlueprintTypeId(Integer blueprintTypeId) {
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
}
