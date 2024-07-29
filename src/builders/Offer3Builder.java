package builders;

import models.*;
import models.abstracts.Accommodation;
import models.abstracts.Activity;
import models.abstracts.Transportation;

public class Offer3Builder extends PackageBuilder {

    @Override
    Transportation buildTransportation() {
        return new Bus();
    }

    @Override
    Accommodation buildAccommodation() {
        return new Motel();
    }

    @Override
    Activity buildActivity() {
        return new SkyDive();
    }
}
