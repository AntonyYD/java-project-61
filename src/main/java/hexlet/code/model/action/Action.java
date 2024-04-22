package hexlet.code.model.action;

import hexlet.code.model.Identity;

import java.util.Scanner;

/**
 * Интерфейс описывает действие.
 */
public interface Action extends Identity {

    /**
     * Действие.
     * @param scanner - сканер для воода данных
     */
    void invoke(Scanner scanner);
}
