package christmas.view.output;

import java.text.DecimalFormat;

public class OrderDiscountOutPut {

    private static final String NEW_LINE = System.lineSeparator();
    private final static String DIVIDED_THOUSAND_DIVIDED = "#,###원";
    private final static String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private final static String GIFT_MENU = "<증정 메뉴>";
    private final static String CHAMPAGNE = "샴페인 1개";
    private final static String NONE = "없음";


    DecimalFormat decimalFormat = new DecimalFormat(DIVIDED_THOUSAND_DIVIDED);

    public void showTotalOrderAmount(int totalPrice) {
        System.out.println(NEW_LINE + TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT);
        System.out.println(decimalFormat.format(totalPrice));
    }

    public void showHasGift(Boolean hasGift) {
        if (hasGift) {
            System.out.println(GIFT_MENU + NEW_LINE + CHAMPAGNE);
        }
        if (!hasGift) {
            System.out.println(GIFT_MENU + NEW_LINE + NONE);
        }
    }
}
