package hexlet.code.sevice;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.Task;

/**
 * Клаас описывает валидацию задания
 * @param <T>
 */
public interface TaskValidator<T extends Task> {
    /**
     * Метод проверяет корректность поставленного задания
     * @param task - задача
     * @throws TaskQuestionException
     */
    void validateQuestion(T task) throws TaskQuestionException;

    /**
     * Метод проверяет корректность ответа
     * @param task - задача
     * @throws TaskAnswerException
     */
    void validateAnswer(T task) throws TaskAnswerException;
}
