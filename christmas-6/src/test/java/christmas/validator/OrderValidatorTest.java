package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderValidatorTest {

    @Test
    @DisplayName("문자열이 숫자가 아닌 경우 예외가 발생하는지 확인")
    void testStaticThrowIsNotNumber() {
        assertThatThrownBy(() -> OrderValidator.throwIsNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("문자열이 숫자가 아닌 경우 예외가 발생하는지 확인")
    void testThrowIsNotNumberWithInstance() {
        assertThatThrownBy(() -> new OrderValidator().throwIsNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("리스트와 맵의 크기가 다를 경우 예외가 발생하는지 확인")
    void testDuplicateVerification() {
        OrderValidator orderValidator = new OrderValidator();
        List<String> inputMenu = List.of("아이스크림", "크로와상", "아메리카노");
        Map<String, Integer> separateByKeyValue = new HashMap<>();
        assertThatThrownBy(() -> orderValidator.duplicateVerification(inputMenu, separateByKeyValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("맵의 키가 숫자인 경우 예외가 발생하는지 확인")
    void testThrowIsNotStringWithMapKeys() {
        OrderValidator orderValidator = new OrderValidator();
        Map<String, Integer> input = Map.of("123", 2, "크로와상", 3, "아메리카노", 1);
        assertThatThrownBy(() -> orderValidator.throwIsNotString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴에 없는 주문이 포함된 경우 예외가 발생하는지 확인")
    void testThrowIsNotMenu() {
        OrderValidator orderValidator = new OrderValidator();
        Map<String, Integer> orderItems = Map.of("아이스크림", 2, "크로와상", 3, "콜라", 1);
        assertThatThrownBy(() -> orderValidator.throwIsNotMenu(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
