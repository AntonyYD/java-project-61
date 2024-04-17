package hexlet.code.sevice;

import hexlet.code.model.game.EvenGame;
import hexlet.code.model.game.Game;
import hexlet.code.model.game.ProgressionGame;
import hexlet.code.model.game.SumGame;
import hexlet.code.model.game.PrimeGame;
import hexlet.code.model.game.MaxSameDivGame;

import java.util.ArrayList;
import java.util.List;

public class GameProviderImpl implements GameProvider {

    private List<Game> registryList = new ArrayList<>();

    public GameProviderImpl() {
        registryList.add(new SumGame());
        registryList.add(new EvenGame());
        registryList.add(new ProgressionGame());
        registryList.add(new PrimeGame());
        registryList.add(new MaxSameDivGame());
    }

    @Override
    public Game getById(int id) {
        return registryList.stream()
                .filter(game -> game.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Game> getAll() {
        return registryList.stream().toList();
    }
}
