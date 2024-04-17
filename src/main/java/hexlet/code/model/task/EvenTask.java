package hexlet.code.model.task;

import java.util.Random;

public class EvenTask extends Task {

    public EvenTask() {
        this.checkValue = valueGenerator.nextInt(1, 100);
    }

    private Integer checkValue;
    private Random valueGenerator = new Random();

    public Integer getCheckValue() {
        return checkValue;
    }

    @Override
    public String getQuestion() {
        return String.format("Answer 'yes' if value %d is even. Otherwise answer 'no' ", checkValue);
    }
}
