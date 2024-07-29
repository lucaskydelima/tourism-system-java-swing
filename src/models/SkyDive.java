package models;

import models.abstracts.Activity;

public class SkyDive extends Activity {
    @Override
    public int getPrice() {
        return 300;
    }

    @Override
    public String toString() {
        return "Amazing Sky Diving";
    }
}
