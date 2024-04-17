package hexlet.code.model.task;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class ProgressionTask extends Task {

    public ProgressionTask() {
        int length = 10;
        int increment = generator.nextInt(1, 10);
        int firsItem = generator.nextInt(1, 100);
        progression.add(firsItem);
        for (int i = 1; i < length; i++) {
            progression.add(progression.get(i - 1) + increment);
        }
        int index = generator.nextInt(0, length - 1);
        progression.set(index, null);
    }

    private Random generator = new Random();
    private ArrayList<Integer> progression = new ArrayList<>();

    public ArrayList<Integer> getProgression() {
        return progression;
    }

    @Override
    public String getQuestion() {
        var progressionString = progression.stream()
                .map(item -> {
                    if (item != null) {
                        return item.toString();
                    } else {
                        return "..";
                    }
                })
                .collect(Collectors.joining(" "));
        return String.format("Progression: %s\nWhat number is missing in this? ", progressionString);
    }

}
