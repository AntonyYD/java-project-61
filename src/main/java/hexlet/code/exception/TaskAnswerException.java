package hexlet.code.exception;

public class TaskAnswerException extends RuntimeException{

    public TaskAnswerException(String message) {
        super(message);
    }

    public TaskAnswerException() {
        super("The task answer is bad!");
    }

}
