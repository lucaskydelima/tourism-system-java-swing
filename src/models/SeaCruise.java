package models;

import models.abstracts.Activity;

public class SeaCruise extends Activity {
    @Override
    public int getPrice() {
        return 200;
    }

    @Override
    public String toString() {
        return "Long Sea Cruise";
    }
}
