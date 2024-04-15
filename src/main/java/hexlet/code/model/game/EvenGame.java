package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.EvenTask;
import hexlet.code.sevice.AnswerValidator;

public class EvenGame implements Game<EvenTask>{

    @Override
    public EvenTask instanceTask() {
        return new EvenTask();
    }

    @Override
    public boolean checkResult(EvenTask task) {
        validateQuestion(task);
        validateAnswer(task);
        String rightAnswer = (task.getCheckValue()%2==0) ? "yes" : "no";
        return task.getAnswer().equalsIgnoreCase(rightAnswer);
    }

    @Override
    public String getName() {
        return "Even number";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public void validateQuestion(EvenTask task) {
        if (task==null || task.getQuestion()==null || task.getQuestion().isBlank()
                || task.getCheckValue()==null || task.getCheckValue()<=0)
            throw new TaskQuestionException();
    }

    @Override
    public void validateAnswer(EvenTask task) throws TaskAnswerException {
        AnswerValidator.yesOrNo(task);
    }
}
