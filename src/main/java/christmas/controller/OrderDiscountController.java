package christmas.controller;

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
                                   OrderDiscountCalculator orderDiscountCalculator, OrderDiscountOutPut orderDiscountOutPut) {
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
        System.out.println("으쌰");
    }
}
