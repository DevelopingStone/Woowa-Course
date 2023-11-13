package christmas.controller;

import christmas.view.output.PaymentOutPut;
import java.util.Map;

public class PaymentController {

    private final PaymentOutPut paymentOutPut;
    private final Map<String, Integer> orderItems;
    private final String day;

    public PaymentController(PaymentOutPut paymentOutPut, Map<String, Integer> orderItems, String day) {
        this.paymentOutPut = paymentOutPut;
        this.orderItems = orderItems;
        this.day = day;
    }

    public void showOrderMenu() {
        paymentOutPut.showMenu(orderItems, day);
        showDiscounts();
    }

    public void showDiscounts(){

    }
}
