package christmas.view.output;

import java.text.DecimalFormat;

public class OrderDiscountOutPut {

    private final static String dividedThousand = "#,###원";
    private final static String TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String NEW_LINE = System.lineSeparator();
    private final static String giveGift = """

            <증정 메뉴>
            샴페인 1개""";
    private final static String notGiveGift = """

            <증정 메뉴>
            없음""";

    DecimalFormat decimalFormat = new DecimalFormat(dividedThousand);

    public void showTotalOrderAmount(int totalPrice) {
        System.out.println(NEW_LINE + TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT);
        System.out.println(decimalFormat.format(totalPrice));
    }

    public void showHasGift(Boolean hasGift) {
        if (hasGift) {
            System.out.println(giveGift);
        }
        if (!hasGift) {
            System.out.println(notGiveGift);
        }
    }
}
