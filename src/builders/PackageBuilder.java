package builders;

import models.PackageOffer;
import models.abstracts.Accommodation;
import models.abstracts.Activity;
import models.abstracts.Transportation;

public abstract class PackageBuilder {
    private PackageOffer packageOffer;

    public PackageOffer createPackage() {
        packageOffer = new PackageOffer();
        packageOffer.setTransportation(buildTransportation());
        packageOffer.setAccommodation(buildAccommodation());
        packageOffer.setActivity(buildActivity());
        return packageOffer;
    }

    abstract Transportation buildTransportation();

    abstract Accommodation buildAccommodation();

    abstract Activity buildActivity();
}
