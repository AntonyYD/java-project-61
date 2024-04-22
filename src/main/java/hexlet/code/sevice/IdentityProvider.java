package hexlet.code.sevice;

import hexlet.code.model.Identity;

import java.util.List;
import java.util.Optional;

/**
 * Фабрика игр.
 */
public interface IdentityProvider {

    /**
     * Метод возвращает экземпляр интерфейса по его идентификатору.
     *
     * @param id - идентифкатор
     * @return - экземляр интерфейса Identity или null, если такой не найден
     */
    Optional<Identity> getById(int id);

    /**
     * Метод возвращает все зарегистрированные экземпляры реализации интерфейса Identity.
     *
     * @return - список экземпляров реализаций интерфейса Identity
     */
    List<Identity> getAll();
}
