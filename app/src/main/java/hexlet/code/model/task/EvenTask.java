package hexlet.code.model.task;

public class EvenTask extends Task {

    public EvenTask(Integer checkValue) {
        this.checkValue = checkValue;
    }

    private final Integer checkValue;

    public Integer getCheckValue() {
        return checkValue;
    }

    @Override
    public String getQuestion() {
        return String.valueOf(checkValue);
    }
}
