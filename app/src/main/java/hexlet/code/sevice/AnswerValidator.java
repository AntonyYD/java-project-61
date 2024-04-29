package hexlet.code.sevice;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.model.task.Task;

public class AnswerValidator {

    public static void intValue(Task task) throws TaskAnswerException {
        try {
            if (task == null || task.getAnswer() == null || task.getAnswer().isBlank()) {
                throw new TaskAnswerException();
            }
            Integer.valueOf(task.getAnswer());
        } catch (NumberFormatException e) {
            throw new TaskAnswerException();
        }
    }

    public static void yesOrNo(Task task) throws TaskAnswerException {
        if (task == null || task.getAnswer() == null
                || (!task.getAnswer().trim().equalsIgnoreCase("no")
                && !task.getAnswer().trim().equalsIgnoreCase("yes"))) {
            throw new TaskAnswerException();
        }
    }
}
