package models.discount;

public class StudentDiscount implements DiscountStrategy{
    @Override
    public int applyDiscount(int totalPrice) {
        return (int) (0.9 * totalPrice);
    }
}
