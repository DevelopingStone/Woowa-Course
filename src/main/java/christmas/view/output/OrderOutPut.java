package christmas.view.output;

public class OrderOutPut extends OutPut{

    private static final String VISITING_INFORMATION_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    @Override
    public void informationMessage() {
        System.out.println(VISITING_INFORMATION_MESSAGE);
    }
}
