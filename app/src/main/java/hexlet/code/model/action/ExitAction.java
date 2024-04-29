package hexlet.code.model.action;


import java.util.Scanner;

public final class ExitAction implements Action {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void invoke(Scanner scanner) {

    }
}
