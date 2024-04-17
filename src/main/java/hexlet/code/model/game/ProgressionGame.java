package hexlet.code.model.game;

import hexlet.code.exception.TaskAnswerException;
import hexlet.code.exception.TaskQuestionException;
import hexlet.code.model.task.ProgressionTask;
import hexlet.code.sevice.AnswerValidator;

public class ProgressionGame implements Game<ProgressionTask> {

    @Override
    public ProgressionTask instanceTask() {
        return new ProgressionTask();
    }

    @Override
    public boolean checkResult(ProgressionTask task) {
        try {
            validateQuestion(task);
            validateAnswer(task);
            int index = task.getProgression().indexOf(null);
            int lastIndex = task.getProgression().size() - 1;
            int firstValue = 0;
            int secondValue = 0;
            if (index == lastIndex || index == 0) {
                if (index == lastIndex) {
                    firstValue = task.getProgression().get(lastIndex - 2);
                    secondValue = task.getProgression().get(lastIndex - 1);
                } else {
                    firstValue = task.getProgression().get(0);
                    secondValue = task.getProgression().get(1);
                }
            } else {
                firstValue = task.getProgression().get(index - 1);
                secondValue = task.getProgression().get(index + 1);
            }
            int rightAnswer = (secondValue + firstValue) / 2;
            return Integer.valueOf(task.getAnswer()) == rightAnswer;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


    @Override
    public String getName() {
        return "Arithmetic progression";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public void validateQuestion(ProgressionTask task) throws TaskQuestionException {
        if (task == null || task.getQuestion() == null || task.getQuestion().isBlank()
                || task.getProgression() == null || task.getProgression().size() < 3
                || task.getProgression().stream().anyMatch(item -> item != null && item <= 0)) {
            throw new TaskQuestionException();
        }
    }

    @Override
    public void validateAnswer(ProgressionTask task) throws TaskAnswerException {
        AnswerValidator.intValue(task);
    }

}
