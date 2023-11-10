package christmas.view.output;

public class DayOutPut extends OutPut {

    private static final String VISITING_INFORMATION_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    @Override
    public void informationMessage() {
        System.out.println(VISITING_INFORMATION_MESSAGE);
    }


}
