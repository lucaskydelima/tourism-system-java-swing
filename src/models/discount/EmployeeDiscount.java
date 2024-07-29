package models.discount;

public class EmployeeDiscount implements DiscountStrategy{
    @Override
    public int applyDiscount(int totalPrice) {
        return (int) (0.7 * totalPrice);
    }
}
