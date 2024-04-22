package hexlet.code;

import hexlet.code.model.Actor;
import hexlet.code.model.Identity;
import hexlet.code.model.action.Action;
import hexlet.code.model.action.GreetAction;
import hexlet.code.model.game.Game;
import hexlet.code.model.task.Task;
import hexlet.code.sevice.IdentityProvider;
import hexlet.code.sevice.IdentityProviderImpl;

import javax.management.InstanceNotFoundException;
import java.util.Scanner;

public class App {

    private static final int TRY_COUNT = 3;

    public static void main(String[] arg) {
        System.out.println("Please enter the game number and press Enter.");

        try (Scanner scanner = new Scanner(System.in);) {
            IdentityProvider identityProvider = new IdentityProviderImpl();
            identityProvider.getAll().forEach(obj -> System.out.println(obj.getId() + " - " + obj.getName()));
            System.out.println("Welcome to the Brain Games!");
            System.out.print(String.format("Your choice: "));
            if (!scanner.hasNextInt()) {
                throw new NumberFormatException("The value type isn't available!");
            }
            int choice = scanner.nextInt();
            Identity chooseObject =
                    identityProvider.getById(choice).orElseThrow(()
                            -> new InstanceNotFoundException("Your choice isn't valid!"));
            if (chooseObject instanceof Game) {
                GreetAction greet = new GreetAction();
                greet.invoke(scanner);
                boolean result = play((Game) chooseObject, scanner);
                leave(greet, result);
            } else if (chooseObject instanceof Action) {
                ((Action) chooseObject).invoke(scanner);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
