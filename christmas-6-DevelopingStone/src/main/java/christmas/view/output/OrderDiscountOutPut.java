package christmas.view.output;

import java.text.DecimalFormat;

public class OrderDiscountOutPut {

    DecimalFormat decimalFormat = new DecimalFormat(OrderDiscount.DIVIDED_THOUSAND_DIVIDED.message());
    int numberOfBenefits = 0;

    public void showTotalOrderAmount(int totalPrice) {
        System.out.println(
                OrderDiscount.NEW_LINE.message() + OrderDiscount.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.message());
        System.out.println(decimalFormat.format(totalPrice));
    }

    public void showHasGift(Boolean hasGift) {
        if (hasGift) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.GIFT_MENU.message()
                    + OrderDiscount.NEW_LINE.message() + OrderDiscount.CHAMPAGNE.message());
        }
        if (!hasGift) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.GIFT_MENU.message()
                    + OrderDiscount.NEW_LINE.message() + OrderDiscount.NONE.message());
        }
    }

    public void showBenefitsDetails() {
        System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.SHOW_BENEFIT.message());
    }

    public void showChristmasDiscount(int christmasDiscount) {
        if (christmasDiscount != OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.printf(OrderDiscount.CHRISTMAS_DEAL_DISCOUNT.message(), decimalFormat.format(christmasDiscount));
            numberOfBenefits++;
        }
    }

    public void showDayDiscount(String day, int dayDiscount) {
        if (dayDiscount != OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.printf(OrderDiscount.NEW_LINE.message() + OrderDiscount.DISCOUNT_FORMAT.message()
                            + OrderDiscount.DISCOUNT.message() + OrderDiscount.DISCOUNT_MINUS_FORMAT.message(), day,
                    decimalFormat.format(dayDiscount));
            numberOfBenefits++;
        }
    }

    public void showSpecialDiscount(int specialDiscount) {
        if (specialDiscount != OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.printf(OrderDiscount.NEW_LINE.message() + OrderDiscount.SPECIAL_DISCOUNT.message()
                    + OrderDiscount.DISCOUNT_MINUS_FORMAT.message(), decimalFormat.format(specialDiscount));
            numberOfBenefits++;
        }
    }

    public void showPresentationEvent(boolean hasGift) {
        if (hasGift) {
            System.out.printf(OrderDiscount.NEW_LINE.message() + OrderDiscount.PRESENTATION_EVENT.message());
            numberOfBenefits++;
        }
    }

    public void showTotalBenefitsMoney(int TotalBenefitsMoney) {
        if (numberOfBenefits == OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.println(OrderDiscount.NONE.message());
        }
        if (TotalBenefitsMoney != OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.NEW_LINE.message()
                    + OrderDiscount.TOTAL_BENEFITS_MONEY.message());
            System.out.printf(OrderDiscount.DISCOUNT_MINUS_FORMAT.message(),
                    decimalFormat.format(TotalBenefitsMoney) + OrderDiscount.NEW_LINE.message());
        }
        if (TotalBenefitsMoney == OrderDiscountNumber.ZERO_MONEY.num()) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.TOTAL_BENEFITS_MONEY.message()
                    + OrderDiscount.NEW_LINE.message() + OrderDiscount.ZERO_MONEY.message());
        }
    }

    public void showExpectedDiscount(int afterDiscount, boolean hasGift) {
        if (hasGift) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.EXPECTED_DISCOUNT.message());
            System.out.printf(decimalFormat.format(afterDiscount + OrderDiscountNumber.CHAMPAGNE.num()));
        }
        if (!hasGift) {
            System.out.println(OrderDiscount.NEW_LINE.message() + OrderDiscount.EXPECTED_DISCOUNT.message());
            System.out.printf(decimalFormat.format(afterDiscount));
        }
    }

    public void showBadge(int benefitsMoney) {
        System.out.println(
                OrderDiscount.NEW_LINE.message() + OrderDiscount.NEW_LINE.message() + OrderDiscount.BADGE.message());
        if (benefitsMoney >= OrderDiscountNumber.BADGE_SANTA.num()) {
            System.out.println(OrderDiscount.SANTA.message());
            return;
        }
        if (benefitsMoney >= OrderDiscountNumber.BADGE_TREE.num()) {
            System.out.println(OrderDiscount.TREE.message());
            return;
        }
        if (benefitsMoney >= OrderDiscountNumber.BADGE_STAR.num()) {
            System.out.println(OrderDiscount.STAR.message());
        }
        System.out.println(OrderDiscount.NONE.message());
    }
}
