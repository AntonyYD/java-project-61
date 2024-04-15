package hexlet.code.sevice;

import hexlet.code.model.game.Game;

import java.util.List;

/**
 * Фабрика игр
 */
public interface GameProvider {

    /**
     * Метод возвращает экземпляр игры по ее типу
     * @param id - тип игры
     * @return - экземляр игры или null, если тип не зарегистрирован
     */
    Game getById(int id);

    /**
     * Метод возвращает все доступные игры
     * @return - список игр
     */
    List<Game> getAll();
}
