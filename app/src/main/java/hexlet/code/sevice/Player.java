package hexlet.code.sevice;

import hexlet.code.model.Actor;
import hexlet.code.model.action.GreetAction;
import hexlet.code.model.game.Game;
import hexlet.code.model.task.Task;

import java.util.Scanner;

public class Player {

    private static final int TRY_COUNT = 3;

    public static void run(Game game, Scanner scanner) {
        GreetAction greet = new GreetAction();
        greet.invoke(scanner);
        var result = play(game, scanner);
        leave(greet, result);
    }

    private static boolean play(Game game, Scanner scanner) {
        boolean result = false;
        System.out.println(game.getDescription());
        for (int i = 0; i < TRY_COUNT; i++) {
            Task task = game.instanceTask();
            System.out.println("Question: " + task.getQuestion());
            System.out.print("Your answer: ");
            String answer = scanner.next();
            task.setAnswer(answer);
            result = game.checkResult(task);
            if (result) {
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.",
                        answer, task.getRightAnswer()));
                break;
            }
        }
        return result;
    }

    private static void leave(Actor actor, boolean isWin) {
        if (isWin) {
            System.out.println(String.format("Congratulations, %s!", actor.getActor()));
        } else {
            System.out.println(String.format("Let's try again, %s!", actor.getActor()));
        }
    }
}
