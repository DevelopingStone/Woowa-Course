package christmas.view.input;

import christmas.validator.Validator;
import christmas.view.output.OutPut;

public class DayInput extends Input {

    private final Validator validator;
    private final OutPut outPut;

    public DayInput(Validator validator, OutPut outPut) {
        this.validator = validator;
        this.outPut = outPut;
    }

    @Override
    public void message() {
        outPut.informationMessage();
    }

    @Override
    public void validate(String data) {
        validator.validate(data);
    }

}
