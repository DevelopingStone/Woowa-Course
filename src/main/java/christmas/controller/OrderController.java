package christmas.controller;

import christmas.model.Order.OrderDataHandler;
import christmas.validator.OrderValidator;
import java.util.List;
import java.util.Map;

public class OrderController implements Controller {
    private final OrderValidator orderValidator;
    public OrderDataHandler orderDataHandler;
    private Map<String, Integer> orderItems;

    public OrderController(OrderValidator orderValidator, OrderDataHandler orderDataHandler) {
        this.orderValidator = orderValidator;
        this.orderDataHandler = orderDataHandler;
    }

    @Override
    public void runController(String data) {
        parserResult orderParser = parser(data);
        validate(orderParser);
        orderValidator.checkDrinkOrderDuplicated(orderItems);
        orderValidator.throwExcessiveOrder(orderItems);
    }

    private void validate(parserResult orderParser) {
        orderValidator.validate(orderParser.dataSplitComma(), orderParser.dataSplitHyphen());
        orderItems = orderParser.dataSplitHyphen();
        orderValidator.throwIsNotMenu(orderItems);
    }

    private parserResult parser(String data) {
        List<String> dataSplitComma = orderDataHandler.splitComma(data);
        Map<String, Integer> dataSplitHyphen = orderDataHandler.splitHyphen(dataSplitComma);
        return new parserResult(dataSplitComma, dataSplitHyphen);
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    private record parserResult(List<String> dataSplitComma, Map<String, Integer> dataSplitHyphen) {
    }
}
