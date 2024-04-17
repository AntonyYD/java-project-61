package hexlet.code.model.game;

import hexlet.code.model.task.Task;
import hexlet.code.sevice.TaskValidator;

/**
 * Описание игры.
 * @param <T>
 */
public interface Game<T extends Task> extends TaskValidator<T> {

    /**
     * Метод создает новое задание.
     * @return - новое задание
     */
    T instanceTask();

    /**
     * Метод проверяет результат выполнения задания.
     * @param task - задание для проверки
     * @return - результат проверки
     */
    boolean checkResult(T task);

    /**
     * Метод возвращает имя игры.
     * @return - имя игры
     */
    String getName();

    /**
     * Метод возвращает идентификатор игры.
     * @return - идентификатор игры
     */
    int getId();
}
