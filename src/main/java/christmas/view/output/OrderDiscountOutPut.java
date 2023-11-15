package christmas.view.output;

import java.text.DecimalFormat;

public class OrderDiscountOutPut {

    private static final String NEW_LINE = System.lineSeparator();
    private final static String DIVIDED_THOUSAND_DIVIDED = "#,###원";
    private final static String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private final static String GIFT_MENU = "<증정 메뉴>";
    private final static String CHAMPAGNE = "샴페인 1개";
    private final static String NONE = "없음";
    private final static String SHOW_BENEFIT = "<혜택 내역>";
    DecimalFormat decimalFormat = new DecimalFormat(DIVIDED_THOUSAND_DIVIDED);
    int benefit_count = 0;

    public void showTotalOrderAmount(int totalPrice) {
        System.out.println(NEW_LINE + TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT);
        System.out.println(decimalFormat.format(totalPrice));
    }

    public void showHasGift(Boolean hasGift) {
        if (hasGift) {
            System.out.println(NEW_LINE + GIFT_MENU + NEW_LINE + CHAMPAGNE);
        }
        if (!hasGift) {
            System.out.println(NEW_LINE + GIFT_MENU + NEW_LINE + NONE);
        }
    }

    public void showBenefitsDetails() {
        System.out.println(NEW_LINE + SHOW_BENEFIT);
    }

    public void showChristmasDiscount(int christmasDiscount) {
        if (christmasDiscount != 0) {
            System.out.printf("크리스마스 디데이 할인: -%s", decimalFormat.format(christmasDiscount));
            benefit_count++;
        }
    }

    public void showDayDiscount(String day, int dayDiscount) {
        if (dayDiscount != 0) {
            System.out.printf(NEW_LINE + "%s 할인: -%s", day, decimalFormat.format(dayDiscount));
            benefit_count++;
        }
    }

    public void showSpecialDiscount(int specialDiscount) {
        if (specialDiscount != 0) {
            System.out.printf(NEW_LINE + "특별 할인: -%s", decimalFormat.format(specialDiscount));
            benefit_count++;
        }
    }

    public void showPresentationEvent(boolean hasGift) {
        if (hasGift) {
            System.out.printf(NEW_LINE + "증정 이벤트: -25,000원");
            benefit_count++;
        }
    }

    public void showTotalBenefitsMoney(int TotalBenefitsMoney) {
        if (benefit_count == 0) {
            System.out.println("없음");
        }
        if (TotalBenefitsMoney != 0) {
            System.out.println();
            System.out.println();
            System.out.println("<총혜택 금액>");
            System.out.printf("-%s", decimalFormat.format(TotalBenefitsMoney));
            System.out.println();
        }
        if (TotalBenefitsMoney == 0) {
            System.out.println();
            System.out.println("<총혜택 금액>");
            System.out.println("0원");
        }
    }

    public void showExpectedDiscount(int totalPrice, int benefitsMoney, boolean hasGift) {
        if (hasGift) {
            System.out.println();
            System.out.println("<할인 후 예상 결제 금액>");
            System.out.printf(decimalFormat.format(totalPrice - benefitsMoney + 25000));
        }
        if (!hasGift) {
            System.out.println();
            System.out.println("<할인 후 예상 결제 금액>");
            System.out.printf(decimalFormat.format(totalPrice - benefitsMoney));
        }
    }




}
