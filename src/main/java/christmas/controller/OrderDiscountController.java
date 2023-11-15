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
    int totalPrice = 0;
    //        totalPrice 총구매가격
    int benefitsMoney = 0;
    //    총혜택가격
    boolean hasGift = true;
    //    12만원이상 증정품 체크
    int christmasDiscount = 0;
    //    크리스마스 디데이할인값
    int dayDiscount = 0;
    //    평일 or 주말할인 값
    String week = "";
    //    특별하인 적용값
    int specialDiscount = 0;


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
//        totalPrice 총구매가격
        orderDiscountOutPut.showTotalOrderAmount(totalPrice);
        hasGift(totalPrice);
//        hasGift를 실행하기 위해 totalPrice 넘겨줌
    }

    public void hasGift(int totalPrice) {
        this.hasGift = orderDiscountCalculator.calculateHasGift(totalPrice);
//        증정메뉴 줄수있는지 판단 (12만원이상)
        orderDiscountOutPut.showHasGift(hasGift);
//        12만원 이상인경우 샴페인출력, 아닌경우 (없음)
        getBenefitsDetails();
//        getBenefitsDetails 데이터 넘겨줌
    }

    public void getBenefitsDetails() {
        orderDiscountOutPut.showBenefitsDetails();
//        <혜택 내역 출력>
        christmasDiscount();

//        dayDiscount 평일할인,주말할인 계산값
        this.dayDiscount = dayDiscount();
//        <총혜택금액>을 위한 +
        benefitsMoney += dayDiscount;

//        day = 요일 값
        this.week = MenuItem.giveDay(Integer.parseInt(day));

//        평일 or 주말할인값 / 요일 출력시키기
        orderDiscountOutPut.showDayDiscount(week, dayDiscount);

//        specialDiscount < 별표 있는 특별할인 메서드 실행
        specialDiscount();

//        -----------------------------------------
//        증정이벤트값 계산
        presentationEvent(hasGift);

//        총혜택금액
        totalBenefit();

//        할인후 예상결제금액
        expectedDiscount();

//        12월 이벤트 배지
        expectedBadge();

    }
//    -----------------------------------------------

    //    christmasDiscount 크리스마스 혜택 계산
    public void christmasDiscount() {
//        크리스마스 디데이 할인 값
        this.christmasDiscount = orderDiscountCalculator.giveChristmasDiscount();

//        <총혜택금액>을 위한 + 
        benefitsMoney += christmasDiscount;

//        출력
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

    //    특별이벤트 계산
    public void specialDiscount() {
        this.specialDiscount = MenuItem.giveSpecialDiscount(Integer.parseInt(day));
//        총혜택금액 계산을 위한 더하기
        benefitsMoney += specialDiscount;
//        출력
        orderDiscountOutPut.showSpecialDiscount(specialDiscount);
    }

    //    증정이벤트계산
    public void presentationEvent(boolean hasGift) {
        if (hasGift) {
            orderDiscountOutPut.showPresentationEvent(true);
            benefitsMoney += 25000;
        }
    }

    //    총혜택금액
    public void totalBenefit() {
        orderDiscountOutPut.showTotalBenefitsMoney(benefitsMoney);
    }

    //    할인후예상결제금액
    public void expectedDiscount() {
        orderDiscountOutPut.showExpectedDiscount(totalPrice,benefitsMoney,hasGift);
    }

    public void expectedBadge(){
        orderDiscountOutPut.showBadge(benefitsMoney);
    }

}
