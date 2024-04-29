package hexlet.code.sevice;

import hexlet.code.model.Identity;
import hexlet.code.model.action.ExitAction;
import hexlet.code.model.action.GreetAction;
import hexlet.code.model.game.CalcGame;
import hexlet.code.model.game.EvenGame;
import hexlet.code.model.game.GCDGame;
import hexlet.code.model.game.PrimeGame;
import hexlet.code.model.game.ProgressionGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class IdentityProviderImpl implements IdentityProvider {

    private List<Identity> registryList = new ArrayList<>();

    public IdentityProviderImpl() {
        registryList.add(new GreetAction());
        registryList.add(new EvenGame());
        registryList.add(new CalcGame());
        registryList.add(new GCDGame());
        registryList.add(new ProgressionGame());
        registryList.add(new PrimeGame());
        registryList.add(new ExitAction());
    }

    @Override
    public Optional<Identity> getById(int id) {
        return registryList.stream()
                .filter(item -> item.getId() == id).findFirst();
    }

    @Override
    public List<Identity> getAll() {
        return registryList.stream().toList();
    }


}
