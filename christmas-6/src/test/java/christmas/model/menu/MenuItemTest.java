package christmas.model.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @Test
    @DisplayName("주문한상품 메뉴에 있는지 확인")
    void testIsItemNameInMenu() {
        assertThat(MenuItem.isItemNameInMenu("아이스크림")).isTrue();
        assertThat(MenuItem.isItemNameInMenu("스프라이트")).isFalse();
    }

    @Test
    @DisplayName("주문서에 유효하지 않은 주문이 있는지 확인")
    void testCheckForInvalidOrders() {
        assertThat(MenuItem.checkForInvalidOrders("아메리카노,아이스크림,레몬에이드")).isTrue();
        assertThat(MenuItem.checkForInvalidOrders("크로와상,딸기라떼")).isTrue();
    }

    @Test
    @DisplayName("주문한 상품의 가격을 계산하는지 확인")
    void testFindProductPrice() {
        assertThat(MenuItem.findProductPrice("초코케이크", 2)).isEqualTo(30000);
    }


    @Test
    @DisplayName("특정 날짜에 메인메뉴 적용되는지 확인")
    void testGiveDayDiscount() {
        assertThat(MenuItem.giveDayDiscount("크리스마스파스타", 2, 2)).isEqualTo(2023 * 2);
    }


    @Test
    @DisplayName("특정 날짜 디저트 할인이 적용되는지 확인")
    void testGiveDayDiscountWithNullDiscountDay() {
        assertThat(MenuItem.giveDayDiscount("초코케이크", 1, 5)).isEqualTo(2023);
    }

    @Test
    @DisplayName("특정 날짜에 할인이 적용되는지 확인 (평일 할인)")
    void testGiveDayDiscountWithWeekday() {
        assertThat(MenuItem.giveDayDiscount("바비큐립", 1, 3)).isEqualTo(0);
    }

    @Test
    @DisplayName("특정 날짜에 할인이 적용되는지 확인 (주말 할인)")
    void testGiveDayDiscountWithWeekend() {
        assertThat(MenuItem.giveDayDiscount("티본스테이크", 2, 2)).isEqualTo(2023 * 2);
    }


    @Test
    @DisplayName("할인 요일을 반환하는지 확인")
    void testGiveDay() {
        assertThat(MenuItem.giveDay(5)).isEqualTo("평일");
    }

    @Test
    @DisplayName("스폐셜 날짜에 할인이 적용되는지 확인")
    void testGiveSpecialDiscount() {
        assertThat(MenuItem.giveSpecialDiscount(24)).isEqualTo(1000);
        assertThat(MenuItem.giveSpecialDiscount(25)).isEqualTo(0);
    }


    @Test
    @DisplayName("주중 할인 여부를 반환하는지 확인")
    void testIsWeekdayDiscount() {
        assertThat(MenuItem.T_BONE_STEAK.isWeekdayDiscount()).isFalse();
        assertThat(MenuItem.ZERO_COLA.isWeekdayDiscount()).isFalse();
    }

    @Test
    @DisplayName("주말 할인 여부를 반환하는지 확인")
    void testIsWeekendDiscount() {
        assertThat(MenuItem.CAESAR_SALAD.isWeekendDiscount()).isFalse();
        assertThat(MenuItem.RED_WINE.isWeekendDiscount()).isFalse();
    }

    @Test
    @DisplayName("메뉴 카테고리를 반환하는지 확인")
    void testGetCategory() {
        assertThat(MenuItem.ICE_CREAM.getCategory()).isEqualTo(MenuCategory.DESSERT);
        assertThat(MenuItem.RED_WINE.getCategory()).isEqualTo(MenuCategory.BEVERAGE);
    }

    @Test
    @DisplayName("메뉴 아이템 이름을 반환하는지 확인")
    void testGetItemName() {
        assertThat(MenuItem.TAPAS.getItemName()).isEqualTo("타파스");
        assertThat(MenuItem.CHAMPAGNE.getItemName()).isEqualTo("샴페인");
    }

    @Test
    @DisplayName("메뉴 아이템 가격을 반환하는지 확인")
    void testGetPrice() {
        assertThat(MenuItem.SEAFOOD_PASTA.getPrice()).isEqualTo(35000);
        assertThat(MenuItem.ZERO_COLA.getPrice()).isEqualTo(3000);
    }
}
