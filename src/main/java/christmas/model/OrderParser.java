package christmas.model;


import christmas.validator.OrderValidator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderParser {

    private static final String DISCERN_COMMA = ",";
    private static final String HYPHEN = "-";

    public List<String> splitComma(String input) {
        String[] inputs = input.split(DISCERN_COMMA);
        return Arrays.asList(inputs);
    }

    public Map<String, Integer> splitHyphen(List<String> input) {
        Map<String, Integer> orderSheet = new HashMap<>();
        for (String inputs : input) {
            String[] parts = inputs.split(HYPHEN);
            for (int menu = 0; menu < parts.length; menu++) {
                separateByKeyValue(menu, parts, orderSheet);
            }
        }
        return orderSheet;
    }

    private void separateByKeyValue(int menu, String[] parts, Map<String, Integer> orderSheet) {
        if (menu % 2 == 0) {
            String foodName = parts[menu];
            int count = 1;
            if (menu + 1 < parts.length) {
                OrderValidator.throwIsNotNumber(parts[menu + 1]);
                count = Integer.parseInt(parts[menu + 1]);
            }
            orderSheet.put(foodName, count);
        }
    }
}
