package hexlet.code.model.task;

import java.util.Random;

public class SumTask extends Task {

    public SumTask() {
        this.firstValue = valueGenerator.nextInt(0, 100);
        this.secondValue = valueGenerator.nextInt(0, 100);
    }

    private Random valueGenerator = new Random();
    private Integer firstValue;
    private Integer secondValue;

    @Override
    public String getQuestion() {
        return String.format("Calculate sum %d and %d ", firstValue, secondValue);
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }

}
