package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.SumTask;
import hexlet.code.sevice.AnswerValidator;

public class SumGame implements Game<SumTask> {

    @Override
    public SumTask instanceTask() {
        return new SumTask();
    }

    @Override
    public boolean checkResult(SumTask task) {
        validateQuestion(task);
        validateAnswer(task);
        int result = Integer.valueOf(task.getAnswer());
        return result == task.getFirstValue() + task.getSecondValue();
    }

    @Override
    public String getName() {
        return "Sum";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public void validateQuestion(SumTask task) throws TaskQuestionException {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getFirstValue() == null || task.getSecondValue() == null
                || task.getFirstValue() < 0 || task.getSecondValue() < 0) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(SumTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }
}
