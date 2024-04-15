package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.MaxSameDivTask;
import hexlet.code.sevice.AnswerValidator;

public class MaxSameDivGame implements Game<MaxSameDivTask>{

    @Override
    public MaxSameDivTask instanceTask() {
        return new MaxSameDivTask();
    }

    @Override
    public boolean checkResult(MaxSameDivTask task) {
        validateQuestion(task);
        validateAnswer(task);
        var answer = Integer.valueOf(task.getAnswer());
        var rightAnswer = 1;
        var i = (task.getFirstValue()>=task.getSecondValue()) ? task.getSecondValue() : task.getFirstValue();
        while (i > 1) {
            if (task.getFirstValue()%i==0 && task.getSecondValue()%i==0) {
                rightAnswer = i;
                break;
            }
            i--;
        }
        return answer == rightAnswer;
    }

    @Override
    public String getName() {
        return "MAX common divisor";
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public void validateQuestion(MaxSameDivTask task) throws TaskQuestionException {
        if (task==null || task.getQuestion()==null || task.getQuestion().isBlank()
                || task.getFirstValue()==null || task.getSecondValue()==null
                || task.getFirstValue()<=0 || task.getSecondValue()<=0)
            throw new TaskQuestionException();
    }

    @Override
    public void validateAnswer(MaxSameDivTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }
}
