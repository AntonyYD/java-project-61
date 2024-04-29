package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.CalcTask;
import hexlet.code.sevice.AnswerValidator;

import java.util.ArrayList;
import java.util.List;

public final class CalcGame extends AbstractGame<CalcTask> {

    {
        availableOperationList.add("+");
        availableOperationList.add("-");
        availableOperationList.add("*");
    }

    static List<String> availableOperationList = new ArrayList<>();

    @Override
    public CalcTask instanceTask() {
        var firstValue = getGenerator().nextInt(0, 100);
        var secondValue = getGenerator().nextInt(0, 100);
        var index = getGenerator().nextInt(0, availableOperationList.size());
        return new CalcTask(firstValue, secondValue, availableOperationList.get(index));
    }

    @Override
    public String getDescription() {
        return "What is the result of the expression?";
    }

    @Override
    public String getName() {
        return "Calc";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public void validateQuestion(CalcTask task) throws TaskQuestionException {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getFirstValue() == null || task.getSecondValue() == null
                || task.getFirstValue() < 0 || task.getSecondValue() < 0
                || !availableOperationList.contains(task.getOperation())) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(CalcTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }

    @Override
    protected String calculateResult(CalcTask task) {
        Integer result;
        switch (task.getOperation()) {
            case "+":
                result = task.getFirstValue() + task.getSecondValue();
                break;
            case "-":
                result = task.getFirstValue() - task.getSecondValue();
                break;
            case "*":
                result = task.getFirstValue() * task.getSecondValue();
                break;
            default:
                throw new TaskQuestionException();
        }
        return String.valueOf(result);
    }
}
