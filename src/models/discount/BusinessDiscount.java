package models.discount;

public class BusinessDiscount implements DiscountStrategy {
    @Override
    public int applyDiscount(int totalPrice) {
        return totalPrice;
    }
}
