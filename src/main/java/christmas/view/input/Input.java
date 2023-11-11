package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.output.OutPut;

public abstract class Input {

    boolean isNotValidInput = true;

    public String readLine() {
        String data = "";
        while (isNotValidInput) {
            try {
                message();
                data = Console.readLine();
                controller(data);
                isNotValidInput = false;
            } catch (IllegalArgumentException ex) {
                OutPut.printErrorMessage(ex.getMessage());
            }
        }
        return data;
    }

    public abstract void message();

    public abstract void controller(String data);

}


