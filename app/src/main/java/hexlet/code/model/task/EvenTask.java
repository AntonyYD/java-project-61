package hexlet.code.model.task;

public final class EvenTask extends Task {

    public EvenTask(Integer value) {
        this.checkValue = value;
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
