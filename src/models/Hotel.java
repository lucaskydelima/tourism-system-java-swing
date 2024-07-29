package models;

import models.abstracts.Accommodation;

public class Hotel extends Accommodation {
    @Override
    public int getPrice() {
        return 80;
    }

    @Override
    public String toString() {
        return "5 Stars Hotel";
    }
}
