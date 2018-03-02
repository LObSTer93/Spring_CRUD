package Data;

import java.util.List;

/**
 * Взаимодействие с БД
 */
public interface Repo {

    /**
     * Получение списка информации из БД
     * @return - список информации из БД
     */
    List<Info> getAll();

    void save(Info info);
}