package christmas.controller;

import christmas.model.Menu.MenuItem;
import christmas.model.Order.OrderDiscountCalculator;
import christmas.view.output.OrderDiscountOutPut;
import christmas.view.output.PaymentOutPut;
import java.util.Map;

public class OrderDiscountController {

    private final PaymentOutPut paymentOutPut;
    private final Map<String, Integer> orderItems;
    private final String day;
    private final OrderDiscountCalculator orderDiscountCalculator;
    private final OrderDiscountOutPut orderDiscountOutPut;

    public OrderDiscountController(PaymentOutPut paymentOutPut, Map<String, Integer> orderItems, String day,
                                   OrderDiscountCalculator orderDiscountCalculator,
                                   OrderDiscountOutPut orderDiscountOutPut) {
        this.paymentOutPut = paymentOutPut;
        this.orderItems = orderItems;
        this.day = day;
        this.orderDiscountCalculator = orderDiscountCalculator;
        this.orderDiscountOutPut = orderDiscountOutPut;
    }

    public void orderList() {
        paymentOutPut.showOrderList(orderItems, day);
        TotalOrderAmount();
    }

    public void TotalOrderAmount() {
        int totalPrice = orderDiscountCalculator.calculateTotalOrder();
        orderDiscountOutPut.showTotalOrderAmount(totalPrice);
        hasGift(totalPrice);
//        totalPrice 총구매가격
    }

    public void hasGift(int totalPrice) {
        boolean hasGift = orderDiscountCalculator.calculateHasGift(totalPrice);
        orderDiscountOutPut.showHasGift(hasGift);
        getBenefitsDetails(hasGift);
    }

    public void getBenefitsDetails(boolean benefitsDetails) {
        orderDiscountOutPut.showBenefitsDetails();
        christmasDiscount();
        dayDiscount();

//        int benefitSumPrice = 0;
//        int dayDiscount = orderDiscountCalculator.giveChristmasDiscount();

    }

//    christmasDiscount 크리스마스 혜택 계산
    public void christmasDiscount() {
        int christmasDiscount = orderDiscountCalculator.giveChristmasDiscount();
        orderDiscountOutPut.showChristmasDiscount(christmasDiscount);
    }

//    dayDiscount 평일할인, 주말할인 계산
    public int dayDiscount() {
        int dayDiscount = 0;
        for (Map.Entry<String, Integer> items : orderItems.entrySet()) {
            dayDiscount += MenuItem.giveDayDiscount(items.getKey(), items.getValue(), Integer.parseInt(day));
        }
        return dayDiscount;
    }

}
