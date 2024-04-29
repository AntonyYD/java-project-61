package hexlet.code.exception;

/**
 * Исключение при неудачной валидации вопроса.
 */
public class TaskQuestionException extends RuntimeException {

    public TaskQuestionException() {
        super("The task question is bad!");
    }

    public TaskQuestionException(String message) {
        super(message);
    }
}
