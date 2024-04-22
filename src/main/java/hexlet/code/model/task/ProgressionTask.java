package hexlet.code.model.task;

import java.util.List;
import java.util.stream.Collectors;

public class ProgressionTask extends Task {

    public ProgressionTask(List<Integer> progression) {
        this.progression = progression;
    }

    private final List<Integer> progression;

    public List<Integer> getProgression() {
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
        return progressionString;
    }

}
