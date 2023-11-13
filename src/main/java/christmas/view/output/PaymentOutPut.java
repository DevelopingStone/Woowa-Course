package christmas.view.output;

import java.util.Map;

public class PaymentOutPut extends OutPut {

    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String DATE_OUTPUT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_OUTPUT = "%s %d개";

    @Override
    public void showInformation() {
        System.out.println(ORDER_MENU);
    }

    public void showMenu(Map<String, Integer> orderItems, String day) {
        System.out.printf(DATE_OUTPUT, day);
        System.out.println();
        System.out.println();
        for (Map.Entry<String, Integer> orderItem : orderItems.entrySet()) {
            System.out.printf(ORDER_MENU_OUTPUT, orderItem.getKey(), orderItem.getValue());
            System.out.println();
        }
    }
}
