package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.EvenTask;
import hexlet.code.sevice.AnswerValidator;

public final class EvenGame extends AbstractGame<EvenTask> {

    private final int id = 2;
    private static final int MAX_NUMBER = 100;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public EvenTask instanceTask() {
        var checkValue = getGenerator().nextInt(1, MAX_NUMBER);
        return new EvenTask(checkValue);
    }

    @Override
    public String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String getName() {
        return "Even";
    }

    @Override
    public void validateQuestion(EvenTask task) {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getCheckValue() == null || task.getCheckValue() <= 0) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(EvenTask task) throws TaskAnswerException {
        AnswerValidator.yesOrNo(task);
    }

    @Override
    protected String calculateResult(EvenTask task) {
        return (task.getCheckValue() % 2 == 0) ? "yes" : "no";
    }
}
