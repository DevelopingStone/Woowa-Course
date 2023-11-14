package christmas.view.output;

import java.util.Map;

public class PaymentOutPut extends OutPut {

    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String DATE_OUTPUT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_OUTPUT = "%s %d개";
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public void showInformation() {
        System.out.println(NEW_LINE + ORDER_MENU);
    }

    public void showOrderList(Map<String, Integer> orderItems, String day) {
        System.out.printf(DATE_OUTPUT + NEW_LINE, day);
        showInformation();
        for (Map.Entry<String, Integer> orderItem : orderItems.entrySet()) {
            System.out.printf(ORDER_MENU_OUTPUT + NEW_LINE, orderItem.getKey(), orderItem.getValue());
        }
    }
}
