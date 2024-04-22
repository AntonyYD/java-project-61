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
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
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
     * @param rightAnswer - верный ответ
     */
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
