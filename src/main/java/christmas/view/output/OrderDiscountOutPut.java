package christmas.view.output;

import java.text.DecimalFormat;

public class OrderDiscountOutPut {

    private final static String dividedThousand = "#,###원";
    private final static String totalOrderAmountBeforeDiscount = "<할인 전 총주문 금액>";

    DecimalFormat decimalFormat = new DecimalFormat(dividedThousand);

    public void showTotalOrderAmount(int totalPrice) {
        System.out.println();
        System.out.println(totalOrderAmountBeforeDiscount);
        System.out.println(decimalFormat.format(totalPrice));
    }
}
