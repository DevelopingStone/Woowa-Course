package christmas.controller;

import christmas.validator.Validator;

public class DayController implements Controller {

    Validator validator;

    public DayController(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(String data) {
        validator.validate(data);
    }
}
