package hexlet.code.model.action;

import hexlet.code.model.Actor;

import java.util.Scanner;

public final class GreetAction implements Action, Actor {

    String actor;

    @Override
    public String getActor() {
        return actor;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Greet";
    }


    @Override
    public void invoke(Scanner scanner) {
        System.out.print("May I have your name? ");
        String name = scanner.next();
        actor = name;
        System.out.println(String.format("Hello, %s!", name));
    }
}
