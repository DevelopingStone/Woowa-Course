package christmas.view.output;

public enum OrderDiscountNumber {
    ZERO_MONEY(0),
    BADGE_SANTA(20000),
    BADGE_TREE(10000),
    BADGE_STAR(5000);

    private final int num;

    OrderDiscountNumber(int num) {
        this.num = num;
    }

    public int num() {
        return num;
    }
}
