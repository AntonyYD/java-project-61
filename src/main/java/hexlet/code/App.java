package hexlet.code;

import hexlet.code.model.game.Game;
import hexlet.code.model.task.Task;
import hexlet.code.sevice.GameProvider;
import hexlet.code.sevice.GameProviderImpl;

import javax.management.InstanceNotFoundException;
import java.util.Scanner;

public class App {

    private static final int TRY_COUNT = 3;

    public static void main(String[] arg) {
        System.out.println("Hello! Welcome to the mind games!");
        System.out.print("Input your name please: ");
        try (Scanner scanner = new Scanner(System.in);) {
            String name = scanner.nextLine();
            GameProvider gameProvider = new GameProviderImpl();
            gameProvider.getAll().forEach(game -> System.out.println(game.getId() + " - " + game.getName()));
            System.out.print(String.format("%s, choose the game number: ", name));
            int gameId = scanner.nextInt();
            Game game = gameProvider.getById(gameId);
            if (game == null) {
                throw new InstanceNotFoundException("The game is unavailable");
            }
            boolean result = false;
            for (int i = 0; i < TRY_COUNT; i++) {
                Task task = game.instanceTask();
                System.out.print(task.getQuestion() + ": ");
                String answer = scanner.next();
                task.setAnswer(answer);
                result = game.checkResult(task);
                if (result) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("It isn't correct!");
                    break;
                }
            }
            if (result) {
                System.out.println(String.format("Congratulations %s, you are a winner!", name));
            } else {
                System.out.println(String.format("Sorry %s, you lost!", name));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
