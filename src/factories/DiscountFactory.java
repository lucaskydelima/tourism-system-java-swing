package factories;

import enums.DiscountType;
import models.discount.*;

import java.util.HashMap;

public class DiscountFactory {

    private static final HashMap<DiscountType, DiscountStrategy> discountMap = new HashMap<>();

    static {
        discountMap.put(DiscountType.STUDENT, new StudentDiscount());
        discountMap.put(DiscountType.EMPLOYEE, new EmployeeDiscount());
        discountMap.put(DiscountType.RETIRED, new RetiredDiscount());
        discountMap.put(DiscountType.BUSINESS, new BusinessDiscount());
    }

    public static DiscountStrategy createDiscount(String type) {
        return discountMap.get(DiscountType.valueOf(type.toUpperCase()));
    }
}
