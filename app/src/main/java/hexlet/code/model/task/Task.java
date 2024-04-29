package hexlet.code.model.task;

/**
 * Класс описывает задание.
 */
public abstract class Task {

    /**
     * Ответ игрока.
     */
    private String answer;

    /**
     * Верный ответ.
     */
    private String rightAnswer;

    /**
     * Метод возвращает текст вопроса.
     *
     * @return - текст вопроса
     */
    public abstract String getQuestion();

    /**
     * Метод возвращает текст ответа.
     *
     * @return - текст ответа
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Метод устанавливает текст ответа.
     *
     * @param value - текст ответа
     */
    public void setAnswer(String value) {
        this.answer = value;
    }

    /**
     * Метод возвращает вернай ответ.
     *
     * @return - верный ответ
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     * Метод устанавливает верный ответ.
     *
     * @param rightValue - верный ответ
     */
    public void setRightAnswer(String rightValue) {
        this.rightAnswer = rightValue;
    }
}
