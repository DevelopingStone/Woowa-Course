package christmas.view.input;

import christmas.controller.Controller;
import christmas.validator.Validator;
import christmas.view.output.OutPut;

public class OrderInput extends Input {

    private final Controller controller;
    private final OutPut outPut;

    public OrderInput(Controller controller, OutPut outPut) {
        this.controller = controller;
        this.outPut = outPut;
    }

    @Override
    public void message() {
        outPut.informationMessage();
    }

    @Override
    public void controller(String data) {
        controller.validate(data);
    }
}
