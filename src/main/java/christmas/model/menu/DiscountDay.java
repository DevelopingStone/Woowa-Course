package christmas.model.menu;

public enum DiscountDay {

    WEEKEND("주말", 1, 2),
    WEEKDAY("평일", 3, 4, 5, 6, 0),
    SPECIAL_DAY("특별 할인일", 3, 10, 17, 24, 25, 31);

    private final String description;
    private final int[] days;

    DiscountDay(String description, int... days) {
        this.description = description;
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public boolean containsDay(int day) {
        for (int validDay : days) {
            if (day % 7 == validDay) {
                return true;
            }
        }
        return false;
    }
}

