package hexlet.code.model.task;

import java.util.Random;

public class PrimeTask extends Task {

    public PrimeTask() {
        this.checkValue = valueGenerator.nextInt(1, 50);
    }

    private Integer checkValue;
    private Random valueGenerator = new Random();

    public Integer getCheckValue() {
        return checkValue;
    }

    @Override
    public String getQuestion() {
        return String.format("Answer 'yes' if number %d is prime. Otherwise answer 'no' ", checkValue);
    }
}
