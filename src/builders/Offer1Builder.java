package builders;

import models.*;
import models.abstracts.Accommodation;
import models.abstracts.Activity;
import models.abstracts.Transportation;

public class Offer1Builder extends PackageBuilder {

    @Override
    Transportation buildTransportation() {
        return new Taxi();
    }

    @Override
    Accommodation buildAccommodation() {
        return new Hotel();
    }

    @Override
    Activity buildActivity() {
        return new SkyDive();
    }
}
