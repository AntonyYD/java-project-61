package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.GCDTask;
import hexlet.code.sevice.AnswerValidator;

public class GCDGame extends AbstractGame<GCDTask> {

    @Override
    public GCDTask instanceTask() {
        var firstValue = generator.nextInt(1, 50);
        var secondValue = generator.nextInt(1, 50);
        return new GCDTask(firstValue, secondValue);
    }

    @Override
    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected String calculateResult(GCDTask task) {
        var result = 1;
        var i = (task.getFirstValue() >= task.getSecondValue()) ? task.getSecondValue() : task.getFirstValue();
        while (i > 1) {
            if (task.getFirstValue() % i == 0 && task.getSecondValue() % i == 0) {
                result = i;
                break;
            }
            i--;
        }
        return String.valueOf(result);
    }

    @Override
    public String getName() {
        return "GCD";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public void validateQuestion(GCDTask task) throws TaskQuestionException {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getFirstValue() == null || task.getSecondValue() == null
                || task.getFirstValue() <= 0 || task.getSecondValue() <= 0) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(GCDTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }
}
