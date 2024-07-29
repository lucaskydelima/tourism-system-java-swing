package factories;

import enums.PackageType;
import builders.Offer1Builder;
import builders.Offer2Builder;
import builders.Offer3Builder;
import models.PackageOffer;

import java.util.HashMap;

public class PackageFactory {

    private static final HashMap<PackageType, PackageOffer> packageMap = new HashMap<>();

    static {
        packageMap.put(PackageType.PACK_1, new Offer1Builder().createPackage());
        packageMap.put(PackageType.PACK_2, new Offer2Builder().createPackage());
        packageMap.put(PackageType.PACK_3, new Offer3Builder().createPackage());
    }

    public static PackageOffer createPackage(String type) {
        return packageMap.get(PackageType.valueOf(type));
    }
}
