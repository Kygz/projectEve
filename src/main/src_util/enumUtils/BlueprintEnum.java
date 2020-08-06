package enumUtils;

public enum BlueprintEnum {
    copying("copying"),
    invention("invention"),
    manufacturing("manufacturing"),
    research_material("research_material"),
    research_time("research_time");

    private final String activityType;

    BlueprintEnum(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityType() {
        return activityType;
    }
}
