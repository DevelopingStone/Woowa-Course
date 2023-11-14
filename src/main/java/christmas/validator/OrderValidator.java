package christmas.validator;


import christmas.model.Menu.MenuItem;
import java.util.List;
import java.util.Map;

public class OrderValidator {

    private static final String NUMBER_REGULAR_EXPRESSION = "^[1-9]+$";
    private static final String STRING_REGULAR_EXPRESSION = "^[0-9]+$";
    private static final String INVALID_STATIC_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final String INVALID_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final String ONLY_DRINKS_ORDER = "주문할 수 없음";

    public static void throwIsNotNumber(String input) {
        if (!input.matches((NUMBER_REGULAR_EXPRESSION))) {
            throw new IllegalArgumentException(INVALID_STATIC_ORDER);
        }
    }

    public void validate(List<String> splitData, Map<String, Integer> separateByKeyValue) {
        duplicateVerification(splitData, separateByKeyValue);
        throwIsNotNumber(separateByKeyValue);
        throwIsNotString(separateByKeyValue);
    }

    public void duplicateVerification(List<String> inputMenu, Map<String, Integer> separateByKeyValue) {
        if (inputMenu.size() != separateByKeyValue.size()) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public void throwIsNotNumber(Map<String, Integer> input) {
        for (Map.Entry<String, Integer> inputValue : input.entrySet()) {
            if (!Integer.toString(inputValue.getValue()).matches((NUMBER_REGULAR_EXPRESSION))) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
        }
    }

    public void throwIsNotString(Map<String, Integer> input) {
        for (Map.Entry<String, Integer> inputKey : input.entrySet()) {
            if (inputKey.getKey().matches((STRING_REGULAR_EXPRESSION))) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
        }
    }

    public void throwIsNotMenu(Map<String, Integer> orderItems) {
        long count = orderItems.keySet().stream()
                .filter(MenuItem::isItemNameInMenu)
                .count();
        if (count != orderItems.size()) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }


    public void checkDrinkOrderDuplicated(Map<String, Integer> orderSheet) {
        long count = orderSheet.keySet().stream()
                .filter(MenuItem::checkForInvalidOrders)
                .count();
        if (count == 0) {
            throw new IllegalArgumentException(ONLY_DRINKS_ORDER);
        }
    }
}
