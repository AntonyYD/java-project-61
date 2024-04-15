package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.PrimeTask;
import hexlet.code.sevice.AnswerValidator;

public class PrimeGame implements Game<PrimeTask>{

    @Override
    public PrimeTask instanceTask() {
        return new PrimeTask();
    }

    @Override
    public boolean checkResult(PrimeTask task) {
        validateQuestion(task);
        validateAnswer(task);
        var divCount = 0;
        for (int i = 1; i <= task.getCheckValue(); i++) {
            if (task.getCheckValue() % i == 0)
                divCount++;
        }
        String rightAnswer = (divCount == 2) ? "yes" : "no";
        return task.getAnswer().equalsIgnoreCase(rightAnswer);
    }

    @Override
    public String getName() {
        return "Prime number";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public void validateQuestion(PrimeTask task) {
        if (task==null || task.getQuestion()==null || task.getQuestion().isBlank()
                || task.getCheckValue()==null || task.getCheckValue()<=0)
            throw new TaskQuestionException();
    }

    @Override
    public void validateAnswer(PrimeTask task) throws TaskAnswerException {
        AnswerValidator.yesOrNo(task);
    }
}
