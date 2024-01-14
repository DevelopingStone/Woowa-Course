package christmas.view.output;

public abstract class OutPut {

    private static final String ERROR = "[ERROR]";

    public static void printErrorMessage(String ex) {
        System.out.println(ERROR + ex);
    }

    public abstract void showInformation();
}
