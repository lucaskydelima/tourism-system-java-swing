package models.discount;

public class RetiredDiscount implements DiscountStrategy{
    @Override
    public int applyDiscount(int totalPrice) {
        return (int) (0.8 * totalPrice);
    }
}
