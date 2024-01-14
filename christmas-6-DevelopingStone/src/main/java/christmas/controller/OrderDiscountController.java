package christmas.controller;

import christmas.model.menu.MenuItem;
import christmas.model.order.OrderDiscountCalculator;
import christmas.view.output.OrderDiscountOutPut;
import christmas.view.output.PaymentOutPut;
import java.util.Map;

public class OrderDiscountController {

    private final PaymentOutPut paymentOutPut;
    private final Map<String, Integer> orderItems;
    private final String day;
    private final OrderDiscountCalculator orderDiscountCalculator;
    private final OrderDiscountOutPut orderDiscountOutPut;
    boolean hasGift = true;
    int christmasDiscount = 0;
    int specialDiscount = 0;
    int benefitsMoney = 0;
    int dayDiscount = 0;
    int totalPrice = 0;
    String week = "";

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
        this.totalPrice = orderDiscountCalculator.calculateTotalOrder();
        orderDiscountOutPut.showTotalOrderAmount(totalPrice);
        hasGift(totalPrice);
    }

    public void hasGift(int totalPrice) {
        this.hasGift = orderDiscountCalculator.calculateHasGift(totalPrice);
        orderDiscountOutPut.showHasGift(hasGift);
        getBenefitsDetails();
    }

    public void getBenefitsDetails() {
        orderDiscountOutPut.showBenefitsDetails();
        christmasDiscount();
        this.dayDiscount = dayDiscount();
        benefitsMoney += dayDiscount;
        this.week = MenuItem.giveDay(Integer.parseInt(day));
        orderDiscountOutPut.showDayDiscount(week, dayDiscount);
        specialDiscount();
        presentationEvent(hasGift);
        totalBenefit();
        expectedDiscount();
        expectedBadge();
    }

    public void christmasDiscount() {
        this.christmasDiscount = orderDiscountCalculator.giveChristmasDiscount();
        benefitsMoney += christmasDiscount;
        orderDiscountOutPut.showChristmasDiscount(christmasDiscount);
    }

    public int dayDiscount() {
        int dayDiscount = 0;
        for (Map.Entry<String, Integer> items : orderItems.entrySet()) {
            dayDiscount += MenuItem.giveDayDiscount(items.getKey(), items.getValue(), Integer.parseInt(day));
        }
        return dayDiscount;
    }

    public void specialDiscount() {
        this.specialDiscount = MenuItem.giveSpecialDiscount(Integer.parseInt(day));
        benefitsMoney += specialDiscount;
        orderDiscountOutPut.showSpecialDiscount(specialDiscount);
    }

    public void presentationEvent(boolean hasGift) {
        if (hasGift) {
            orderDiscountOutPut.showPresentationEvent(true);
            benefitsMoney += 25000;
        }
    }

    public void totalBenefit() {
        orderDiscountOutPut.showTotalBenefitsMoney(benefitsMoney);
    }

    public void expectedDiscount() {
        orderDiscountOutPut.showExpectedDiscount(totalPrice - benefitsMoney, hasGift);
    }

    public void expectedBadge() {
        orderDiscountOutPut.showBadge(benefitsMoney);
    }
}
