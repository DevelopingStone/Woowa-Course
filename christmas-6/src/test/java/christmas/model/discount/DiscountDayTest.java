package christmas.model.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountDayTest {

    @Test
    @DisplayName("주말로 인식하는지 테스트")
    void testWeekendContainsDay() {
        assertThat(DiscountDay.WEEKEND.containsDay(1)).isTrue();
        assertThat(DiscountDay.WEEKEND.containsDay(2)).isTrue();
        assertThat(DiscountDay.WEEKEND.containsDay(3)).isFalse();
    }

    @Test
    @DisplayName("평일로 인식하는지 테스트")
    void testWeekdayContainsDay() {
        assertThat(DiscountDay.WEEKDAY.containsDay(1)).isFalse();
        assertThat(DiscountDay.WEEKDAY.containsDay(2)).isFalse();
        assertThat(DiscountDay.WEEKDAY.containsDay(3)).isTrue();
        assertThat(DiscountDay.WEEKDAY.containsDay(6)).isTrue();
    }

    @Test
    @DisplayName("스폐셜데이로 인식하는지 테스트")
    void testSpecialDayContainsDay() {
        assertThat(DiscountDay.SPECIAL_DAY.containsDay(2)).isFalse();
        assertThat(DiscountDay.SPECIAL_DAY.containsDay(15)).isFalse();
        assertThat(DiscountDay.SPECIAL_DAY.containsDay(24)).isTrue();
    }
}
