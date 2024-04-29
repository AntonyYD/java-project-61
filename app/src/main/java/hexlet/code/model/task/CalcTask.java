package hexlet.code.model.task;


public final class CalcTask extends Task {

    public CalcTask(Integer firstValue, Integer secondValue, String operation) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    private final Integer firstValue;
    private final Integer secondValue;
    private final String operation;

    @Override
    public String getQuestion() {
        return String.format("%d %s %d ", firstValue, operation, secondValue);
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }

    public String getOperation() {
        return operation;
    }
}
