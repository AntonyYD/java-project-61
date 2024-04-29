package hexlet.code;

import hexlet.code.model.Identity;
import hexlet.code.model.action.Action;
import hexlet.code.model.game.Game;
import hexlet.code.sevice.IdentityProvider;
import hexlet.code.sevice.IdentityProviderImpl;
import hexlet.code.sevice.Player;

import javax.management.InstanceNotFoundException;
import java.util.Scanner;

public class App {


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
                Player.run((Game) chooseObject, scanner);
            } else if (chooseObject instanceof Action) {
                ((Action) chooseObject).invoke(scanner);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
