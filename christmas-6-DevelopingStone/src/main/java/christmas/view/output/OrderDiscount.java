package christmas.view.output;

public enum OrderDiscount {

    NEW_LINE(System.lineSeparator()),
    NONE("없음"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    DIVIDED_THOUSAND_DIVIDED("#,###원"),
    GIFT_MENU("<증정 메뉴>"),
    CHAMPAGNE("샴페인 1개"),
    SHOW_BENEFIT("<혜택 내역>"),
    CHRISTMAS_DEAL_DISCOUNT("크리스마스 디데이 할인: -%s"),
    DISCOUNT(" 할인 "),
    SPECIAL_DISCOUNT("특별 할인: "),
    PRESENTATION_EVENT("증정 이벤트: -25,000원"),
    ZERO_MONEY("0원"),
    DISCOUNT_FORMAT("%s"),
    DISCOUNT_MINUS_FORMAT("-%s"),
    TOTAL_BENEFITS_MONEY("<총혜택 금액>"),
    EXPECTED_DISCOUNT("<할인 후 예상 결제 금액>"),
    BADGE("<12월 이벤트 배지>"),
    SANTA("산타"),
    TREE("트리"),
    STAR("별");

    private final String message;

    OrderDiscount(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
