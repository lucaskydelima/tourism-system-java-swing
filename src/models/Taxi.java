package models;

import models.abstracts.Transportation;

public class Taxi extends Transportation {
    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public String toString() {
        return "Uber Taxi";
    }
}
