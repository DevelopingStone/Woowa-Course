package christmas.model.Order;

import christmas.model.Menu.MenuItem;
import java.util.Map;

public class OrderDiscountCalculator {
    private final int hasGift = 120_000;
    private final Map<String, Integer> orderItems;
    private final String day;

    public OrderDiscountCalculator(Map<String, Integer> orderItems, String day) {
        this.orderItems = orderItems;
        this.day = day;
    }

    public int calculateTotalOrder() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> orderItem : orderItems.entrySet()) {
            totalPrice += MenuItem.findProductPrice(orderItem.getKey(), orderItem.getValue());
        }
        return totalPrice;
    }

    public boolean calculateHasGift(int totalPrice) {
        if (totalPrice >= hasGift) {
            return true;
        }
        return false;
    }


}
