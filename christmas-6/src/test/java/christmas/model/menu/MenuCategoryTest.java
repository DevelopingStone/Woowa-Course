package christmas.model.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuCategoryTest {

    @Test
    @DisplayName("Appetizer 카테고리 테스트")
    void testAppetizerCategory() {
        MenuCategory appetizer = MenuCategory.APPETIZER;
        assertThat(appetizer.getCategoryName()).isEqualTo("애피타이저");
    }

    @Test
    @DisplayName("Main 카테고리 테스트")
    void testMainCategory() {
        MenuCategory main = MenuCategory.MAIN;
        assertThat(main.getCategoryName()).isEqualTo("메인");
    }

    @Test
    @DisplayName("Dessert 카테고리 테스트")
    void testDessertCategory() {
        MenuCategory dessert = MenuCategory.DESSERT;
        assertThat(dessert.getCategoryName()).isEqualTo("디저트");
    }

    @Test
    @DisplayName("Beverage 카테고리 테스트")
    void testBeverageCategory() {
        MenuCategory beverage = MenuCategory.BEVERAGE;
        assertThat(beverage.getCategoryName()).isEqualTo("음료");
    }
}

