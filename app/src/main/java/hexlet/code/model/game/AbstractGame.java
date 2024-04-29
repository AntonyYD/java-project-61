package hexlet.code.model.game;

import hexlet.code.model.task.Task;

import java.util.Random;

public abstract class AbstractGame<T extends Task> implements Game<T> {

    public AbstractGame(int id) {
        this.id = id;
    }

    protected int id;

    private final Random generator = new Random();

    /**
     * Метод возвращает генератор.
     * @return  генератор
     */
    protected Random getGenerator() {
        return generator;
    }


    /**
     * Метод проверяет корректность данных задания.
     *
     * @param task - задание
     * @return true если задание корректно, иначе false
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
     * Метод проверяет результат задания.
     *
     * @param task - задание для проверки
     * @return true если ответ верен, иначе false
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

    @Override
    public int getId() {
        return id;
    }
}
