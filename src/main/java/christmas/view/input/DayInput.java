package christmas.view.input;

import christmas.controller.Controller;
import christmas.view.output.OutPut;

public class DayInput extends Input {

    private final Controller controller;
    private final OutPut outPut;

    public DayInput(Controller controller, OutPut outPut) {
        this.controller = controller;
        this.outPut = outPut;
    }

    @Override
    public void message() {
        outPut.showInformation();
    }

    @Override
    public void controller(String data) {
        controller.runController(data);
    }
}
