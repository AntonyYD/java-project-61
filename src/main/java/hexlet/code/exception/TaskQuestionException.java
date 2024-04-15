package hexlet.code.exception;

public class TaskQuestionException extends RuntimeException{

    public TaskQuestionException() {
        super("The task question is bad!");
    }

    public TaskQuestionException(String message) {
        super(message);
    }
}
