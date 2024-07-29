package factories;

import enums.ActivityType;
import models.abstracts.Activity;
import models.SeaCruise;
import models.SkyDive;

import java.util.HashMap;

public class ActivityFactory {

    private static final String EMPTY_SPACE = " ";
    private static final String UNDERSCORE = "_";

    private static final HashMap<ActivityType, Activity> activityMap = new HashMap<>();

    static {
        activityMap.put(ActivityType.SEA_CRUISE, new SeaCruise());
        activityMap.put(ActivityType.SKY_DIVING, new SkyDive());
    }

    public static Activity createActivity(String type) {
        return activityMap.get(ActivityType.valueOf(type.toUpperCase().replace(EMPTY_SPACE, UNDERSCORE)));
    }
}
