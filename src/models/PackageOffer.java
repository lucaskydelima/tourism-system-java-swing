package models;

import models.abstracts.Accommodation;
import models.abstracts.Activity;
import models.abstracts.Transportation;

import java.io.Serializable;

public class PackageOffer implements Serializable {

    private Transportation transportation;
    private Accommodation accommodation;
    private Activity activity;


    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getPackagePrice() {
        return transportation.getPrice() + accommodation.getPrice() + activity.getPrice();
    }

    @Override
    public String toString() {
        return "PackageOffer{" +
                "transportation=" + transportation +
                ", accommodation=" + accommodation +
                ", activity=" + activity +
                '}';
    }
}
