package christmas.model.order;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class OrderDiscountCalculatorTest {

    @Test
    @DisplayName("크리스마스 할인이 정확하게 계산되는지 확인")
    void testGiveChristmasDiscount() {
        Map<String, Integer> orderItems = new HashMap<>();
        OrderDiscountCalculator calculator = new OrderDiscountCalculator(orderItems, "10");
        assertThat(calculator.giveChristmasDiscount()).isEqualTo(1900);
    }

    @Test
    @DisplayName("주문한 상품의 총 가격이 정확하게 계산되는지 확인")
    void testCalculateTotalOrder() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("아이스크림", 2);
        orderItems.put("크로와상", 1);
        OrderDiscountCalculator calculator = new OrderDiscountCalculator(orderItems, "5");
        assertThat(calculator.calculateTotalOrder()).isEqualTo(10000);
    }

    @Test
    @DisplayName("선물이 있는지 여부가 정확하게 판단되는지 확인")
    void testCalculateHasGift() {
        Map<String, Integer> orderItems = new HashMap<>();
        OrderDiscountCalculator calculator = new OrderDiscountCalculator(orderItems, "12");
        assertThat(calculator.calculateHasGift(130000)).isTrue();
        assertThat(calculator.calculateHasGift(100000)).isFalse();
    }
}
