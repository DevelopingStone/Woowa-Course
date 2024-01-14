package christmas;

import christmas.controller.DayController;
import christmas.controller.OrderController;
import christmas.controller.OrderDiscountController;
import christmas.model.order.OrderDataHandler;
import christmas.model.order.OrderDiscountCalculator;
import christmas.validator.DayValidator;
import christmas.validator.OrderValidator;
import christmas.validator.Validator;
import christmas.view.input.DayInput;
import christmas.view.input.OrderInput;
import christmas.view.output.DayOutPut;
import christmas.view.output.OrderDiscountOutPut;
import christmas.view.output.OrderOutPut;
import christmas.view.output.PaymentOutPut;

public class Application {
    public static void main(String[] args) {

        Validator validatorDay = new DayValidator();
        DayController controllerDay = new DayController(validatorDay);
        DayOutPut outPutDay = new DayOutPut();
        DayInput inputDay = new DayInput(controllerDay, outPutDay);
        String day = inputDay.readLine();

        OrderValidator validatorOrder = new OrderValidator();
        OrderDataHandler orderDataHandler = new OrderDataHandler();
        OrderDiscountController orderDiscountController = getOrderDiscountController(validatorOrder,
                orderDataHandler, day);
        orderDiscountController.orderList();

    }

    private static OrderDiscountController getOrderDiscountController(OrderValidator validatorOrder,
                                                                      OrderDataHandler orderDataHandler, String day) {
        OrderController controllerOrder = new OrderController(validatorOrder, orderDataHandler);
        OrderOutPut outPutOrder = new OrderOutPut();
        OrderInput inputOrder = new OrderInput(controllerOrder, outPutOrder);
        inputOrder.readLine();

        OrderDiscountCalculator orderDiscountCalculator = new OrderDiscountCalculator(controllerOrder.getOrderItems(),
                day);
        PaymentOutPut paymentOutPut = new PaymentOutPut();
        OrderDiscountOutPut orderDiscountOutPut = new OrderDiscountOutPut();
        return new OrderDiscountController(paymentOutPut,
                controllerOrder.getOrderItems(), day, orderDiscountCalculator, orderDiscountOutPut);
    }
}
