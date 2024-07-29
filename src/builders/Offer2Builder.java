package builders;

import models.*;
import models.abstracts.Accommodation;
import models.abstracts.Activity;
import models.abstracts.Transportation;

public class Offer2Builder extends PackageBuilder {

    @Override
    Transportation buildTransportation() {
        return new Bus();
    }

    @Override
    Accommodation buildAccommodation() {
        return new Hotel();
    }

    @Override
    Activity buildActivity() {
        return new SeaCruise();
    }
}
