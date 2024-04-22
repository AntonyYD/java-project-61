package hexlet.code.model.task;

public class PrimeTask extends Task {

    public PrimeTask(Integer checkValue) {
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
