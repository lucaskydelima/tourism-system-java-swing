package factories;

import enums.AccommodationType;
import models.abstracts.Accommodation;
import models.Hotel;
import models.Motel;

import java.util.HashMap;

public class AccommodationFactory {

    private static final HashMap<AccommodationType, Accommodation> accommodationMap = new HashMap<>();

    static {
        accommodationMap.put(AccommodationType.HOTEL, new Hotel());
        accommodationMap.put(AccommodationType.MOTEL, new Motel());
    }

    public static Accommodation createAccommodation(String type){
        return accommodationMap.get(AccommodationType.valueOf(type.toUpperCase()));
    }
}
