package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.PrimeTask;
import hexlet.code.sevice.AnswerValidator;

public final class PrimeGame extends AbstractGame<PrimeTask> {

    private final int id = 6;

    @Override
    public PrimeTask instanceTask() {
        var checkValue = getGenerator().nextInt(1, 50);
        return new PrimeTask(checkValue);
    }

    @Override
    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    protected String calculateResult(PrimeTask task) {
        var divCount = 0;
        for (int i = 1; i <= task.getCheckValue(); i++) {
            if (task.getCheckValue() % i == 0) {
                divCount++;
            }
        }
        return (divCount == 2) ? "yes" : "no";
    }

    @Override
    public String getName() {
        return "Prime";
    }

    @Override
    public void validateQuestion(PrimeTask task) {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getCheckValue() == null || task.getCheckValue() <= 0) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(PrimeTask task) throws TaskAnswerException {
        AnswerValidator.yesOrNo(task);
    }

    @Override
    public int getId() {
        return id;
    }
}
