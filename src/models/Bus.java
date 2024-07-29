package models;

import models.abstracts.Transportation;

public class Bus extends Transportation {
    @Override
    public int getPrice() {
        return 30;
    }

    @Override
    public String toString() {
        return "Private Bus";
    }
}
