package hexlet.code.model.task;


public final class CalcTask extends Task {

    public CalcTask(Integer first, Integer second, String action) {
        this.firstValue = first;
        this.secondValue = second;
        this.operation = action;
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
