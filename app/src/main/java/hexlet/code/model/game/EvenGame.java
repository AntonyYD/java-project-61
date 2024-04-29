package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.EvenTask;
import hexlet.code.sevice.AnswerValidator;

public class EvenGame extends AbstractGame<EvenTask> {

    @Override
    public EvenTask instanceTask() {
        var checkValue = generator.nextInt(1, 100);
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
    public int getId() {
        return 2;
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
