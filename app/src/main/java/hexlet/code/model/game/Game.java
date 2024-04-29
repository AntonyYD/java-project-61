package hexlet.code.model.game;

import hexlet.code.model.Identity;
import hexlet.code.model.task.Task;
import hexlet.code.sevice.TaskValidator;

/**
 * Описание игры.
 *
 * @param <T>
 */
public interface Game<T extends Task> extends TaskValidator<T>, Identity {

    /**
     * Метод создает новое задание.
     *
     * @return - новое задание
     */
    T instanceTask();

    /**
     * Метод проверяет результат выполнения задания.
     *
     * @param task - задание для проверки
     * @return - результат проверки
     */
    boolean checkResult(T task);

//    /**
//     * Метод возвращает правильный результат
//     * @param task - задание для проверки
//     * @return - результат проверки
//     */
//    String getRightResult(T task);

    /**
     * Метод возвращает описание игры.
     *
     * @return - описание
     */
    String getDescription();

}
