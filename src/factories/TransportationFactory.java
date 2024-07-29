package factories;

import enums.TransportationType;
import models.Bus;
import models.Taxi;
import models.abstracts.Transportation;

import java.util.HashMap;

public class TransportationFactory {

    private static final HashMap<TransportationType, Transportation> transportationMap = new HashMap<>();

    static {

        transportationMap.put(TransportationType.TAXI, new Taxi());
        transportationMap.put(TransportationType.BUS, new Bus());

    }

    public static Transportation createTransportation(String type) {
        return transportationMap.get(TransportationType.valueOf(type.toUpperCase()));
    }
}
