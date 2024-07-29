package models;

import models.abstracts.Accommodation;

public class Motel extends Accommodation {
    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public String toString() {
        return "4 Stars Hotel";
    }
}
