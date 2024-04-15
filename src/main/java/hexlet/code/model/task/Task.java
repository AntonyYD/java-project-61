package hexlet.code.model.task;

/**
 * Класс описывает задание
 */
public abstract class Task {

    /**
     * Ответ
     */
    private String answer;

    /**
     * Метод возвращает текст вопроса
     * @return - текст вопроса
     */
    public abstract String getQuestion();

    /**
     * Метод возвращает текст ответа
     * @return - текст ответа
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Метод устанавливает текст ответа
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
