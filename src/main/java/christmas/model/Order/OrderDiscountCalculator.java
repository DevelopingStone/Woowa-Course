package christmas.model.Order;

import christmas.model.Menu.MenuItem;
import java.util.Map;

public class OrderDiscountCalculator {
    private final Map<String, Integer> orderItems;
    private final String day;
    private int totalPrice;

    public OrderDiscountCalculator(Map<String, Integer> orderItems, String day) {
        this.orderItems = orderItems;
        this.day = day;
    }

    public int giveChristmasDiscount() {
        int dayDiscount = Integer.parseInt(day) - 1;
        if (dayDiscount < 25) {
            return (dayDiscount * 100) + 1000;
        }
        return 0;
    }


    public int calculateTotalOrder() {
        for (Map.Entry<String, Integer> orderItem : orderItems.entrySet()) {
            totalPrice += MenuItem.findProductPrice(orderItem.getKey(), orderItem.getValue());
        }
        return totalPrice;
    }

    public boolean calculateHasGift(int totalPrice) {
        int HAS_GIFT = 120_000;
        return totalPrice >= HAS_GIFT;
    }


}
