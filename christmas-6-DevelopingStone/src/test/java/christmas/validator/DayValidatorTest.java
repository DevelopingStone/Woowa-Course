package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayValidatorTest {

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생하는지 확인")
    void testThrowIsNotNumber() {
        DayValidator dayValidator = new DayValidator();
        assertThatThrownBy(() -> dayValidator.throwIsNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("입력값이 숫자 범위를 벗어날 경우 예외가 발생하는지 확인")
    void testThrowIsNotRange() {
        DayValidator dayValidator = new DayValidator();
        assertThatThrownBy(() -> dayValidator.throwIsNotRange("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> dayValidator.throwIsNotRange("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("유효한 날짜인 경우 아무 예외가 발생하지 않는지 확인")
    void testValidateValidDate() {
        DayValidator dayValidator = new DayValidator();
        assertThatCode(() -> dayValidator.validate("15")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생하는지 확인")
    void testThrowIsNotNumberWithInstance() {
        assertThatThrownBy(() -> new DayValidator().throwIsNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("입력값이 숫자 범위를 벗어날 경우 예외가 발생하는지 확인")
    void testThrowIsNotRangeWithInstance() {
        assertThatThrownBy(() -> new DayValidator().throwIsNotRange("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

        assertThatThrownBy(() -> new DayValidator().throwIsNotRange("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(" 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("유효한 날짜인 경우 아무 예외가 발생하지 않는지 확인 ")
    void testValidateValidDateWithInstance() {
        assertThatCode(() -> new DayValidator().validate("15")).doesNotThrowAnyException();
    }
}
