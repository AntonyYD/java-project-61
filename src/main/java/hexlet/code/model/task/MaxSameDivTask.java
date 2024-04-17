package hexlet.code.model.task;

import java.util.Random;

public class MaxSameDivTask extends Task {

    public MaxSameDivTask() {
        this.firstValue = valueGenerator.nextInt(1, 50);
        this.secondValue = valueGenerator.nextInt(1, 50);
    }

    private Random valueGenerator = new Random();
    private Integer firstValue;
    private Integer secondValue;

    @Override
    public String getQuestion() {
        return String.format("Determine the same max divisor for %d and %d ", firstValue, secondValue);
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }
}
