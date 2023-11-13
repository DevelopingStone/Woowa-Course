package christmas.validator;

public class DayValidator implements Validator {

    private final static String INVALID_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final static String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";
    private final static int DAY_NUM_MIN_RANGE = 1;
    private final static int DAY_NUM_MAX_RANGE = 31;

    @Override
    public void validate(String input) {
        throwIsNotNumber(input);
        throwIsNotRange(input);
    }

    public void throwIsNotNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public void throwIsNotRange(String input) {
        int day = Integer.parseInt(input);
        if (day < DAY_NUM_MIN_RANGE || DAY_NUM_MAX_RANGE < day) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }
}
