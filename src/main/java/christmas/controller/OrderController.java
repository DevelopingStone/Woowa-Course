package christmas.controller;

import christmas.model.OrderParser;
import christmas.validator.OrderValidator;
import java.util.List;
import java.util.Map;

public class OrderController implements Controller {

    OrderValidator orderValidator;
    OrderParser orderParser;

    public OrderController(OrderValidator orderValidator, OrderParser orderParser) {
        this.orderValidator = orderValidator;
        this.orderParser = orderParser;
    }

    @Override
    public void validate(String data) {
        parserResult orderParser = parser(data);
        orderValidator.validate(orderParser.dataSplitComma(), orderParser.dataSplitHyphen());
        System.out.println(orderParser.dataSplitHyphen());
    }

    private parserResult parser(String data) {
        List<String> dataSplitComma = orderParser.splitComma(data);
        Map<String, Integer> dataSplitHyphen = orderParser.splitHyphen(dataSplitComma);
        return new parserResult(dataSplitComma, dataSplitHyphen);
    }

    private record parserResult(List<String> dataSplitComma, Map<String, Integer> dataSplitHyphen) {
    }
}
