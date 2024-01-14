package christmas.model.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderDataHandlerTest {

    @Test
    @DisplayName("쉼표로 문자열을 분리하는지 확인")
    void testSplitComma() {
        OrderDataHandler orderDataHandler = new OrderDataHandler();
        String input = "아이스크림,크로와상,아메리카노";
        assertThat(orderDataHandler.splitComma(input))
                .containsExactly("아이스크림", "크로와상", "아메리카노");
    }

    @Test
    @DisplayName("하이픈으로 문자열을 분리하고 음식 이름과 수량을 매핑하는지 확인")
    void testSplitHyphen() {
        OrderDataHandler orderDataHandler = new OrderDataHandler();
        List<String> input = Arrays.asList("아이스크림-2", "크로와상-3", "아메리카노-1");
        assertThat(orderDataHandler.splitHyphen(input))
                .containsExactlyInAnyOrderEntriesOf(Map.of("아이스크림", 2, "크로와상", 3, "아메리카노", 1));
    }
}
