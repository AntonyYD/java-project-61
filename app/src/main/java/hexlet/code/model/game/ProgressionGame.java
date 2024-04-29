package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.ProgressionTask;
import hexlet.code.sevice.AnswerValidator;

import java.util.ArrayList;
import java.util.List;

public final class ProgressionGame extends AbstractGame<ProgressionTask> {

    private final int id = 5;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_INCREMENT = 10;
    private static final int SIZE = 10;
    private static final int MIN_COUNT = 3;

    @Override
    public ProgressionTask instanceTask() {
        List<Integer> progression = new ArrayList();
        int increment = getGenerator().nextInt(1, MAX_INCREMENT);
        int firsItem = getGenerator().nextInt(1, MAX_NUMBER);
        progression.add(firsItem);
        for (int i = 1; i < SIZE; i++) {
            progression.add(progression.get(i - 1) + increment);
        }
        int index = getGenerator().nextInt(0, SIZE);
        progression.set(index, null);
        return new ProgressionTask(progression);
    }


    @Override
    public String getDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    protected String calculateResult(ProgressionTask task) {
        Integer result;
        int index = task.getProgression().indexOf(null);
        int lastIndex = task.getProgression().size() - 1;
        int firstValue;
        int secondValue;
        if (index == lastIndex || index == 0) {
            if (index == lastIndex) {
                firstValue = task.getProgression().get(index - 2);
                secondValue = task.getProgression().get(index - 1);
                var increment = secondValue - firstValue;
                result = secondValue + increment;
            } else {
                firstValue = task.getProgression().get(index + 1);
                secondValue = task.getProgression().get(index + 2);
                var increment = secondValue - firstValue;
                result = firstValue - increment;
            }
        } else {
            firstValue = task.getProgression().get(index - 1);
            secondValue = task.getProgression().get(index + 1);
            result = (secondValue + firstValue) / 2;
        }
        return String.valueOf(result);
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return "Progression";
    }

    @Override
    public void validateQuestion(ProgressionTask task) throws TaskQuestionException {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getProgression() == null || task.getProgression().size() < MIN_COUNT
                || task.getProgression().stream().anyMatch(item -> item != null && item <= 0)) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(ProgressionTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }

}
