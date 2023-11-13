package christmas.controller;

import christmas.model.OrderParser;
import christmas.validator.OrderValidator;
import java.util.List;
import java.util.Map;

public class OrderController implements Controller {
    private final OrderValidator orderValidator;
    private final OrderParser orderParser;
    private Map<String, Integer> orderItems;

    public OrderController(OrderValidator orderValidator, OrderParser orderParser) {
        this.orderValidator = orderValidator;
        this.orderParser = orderParser;
    }

    @Override
    public void validate(String data) {
        parserResult orderParser = parser(data);
        orderValidator.validate(orderParser.dataSplitComma(), orderParser.dataSplitHyphen());
        this.orderItems = orderParser.dataSplitHyphen();
        orderValidator.throwIsNotMenu(orderItems);
    }

    private parserResult parser(String data) {
        List<String> dataSplitComma = orderParser.splitComma(data);
        Map<String, Integer> dataSplitHyphen = orderParser.splitHyphen(dataSplitComma);
        return new parserResult(dataSplitComma, dataSplitHyphen);
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    private record parserResult(List<String> dataSplitComma, Map<String, Integer> dataSplitHyphen) {
    }
}
