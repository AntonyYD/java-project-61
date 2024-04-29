package hexlet.code.model.task;

public final class GCDTask extends Task {
    public GCDTask(Integer first, Integer second) {
        this.firstValue = first;
        this.secondValue = second;
    }

    private final Integer firstValue;
    private final Integer secondValue;

    @Override
    public String getQuestion() {
        return String.format("%d %d", firstValue, secondValue);
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }
}
