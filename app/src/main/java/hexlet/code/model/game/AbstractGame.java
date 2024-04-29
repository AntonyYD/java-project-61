package hexlet.code.model.game;

import hexlet.code.model.task.Task;

import java.util.Random;

public abstract class AbstractGame<T extends Task> implements Game<T> {

    private final Random generator = new Random();

    protected Random getGenerator() {
        return generator;
    }


    /**
     * Метод проверяет корректность данных задания
     * @param task
     * @return
     */
    protected boolean isValidData(T task) {
        try {
            validateQuestion(task);
            validateAnswer(task);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Метод проверяет результат задания
     * @param task - задание для проверки
     * @return
     */
    @Override
    public boolean checkResult(T task) {
        if (!isValidData(task)) {
            return false;
        }
        String rightAnswer = calculateResult(task);
        task.setRightAnswer(rightAnswer);
        return task.getAnswer().equalsIgnoreCase(rightAnswer);
    }

    protected abstract String calculateResult(T task);
}
