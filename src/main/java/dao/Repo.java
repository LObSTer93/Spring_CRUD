package dao;

import java.util.List;

/**
 * Взаимодействие с БД
 */
public interface Repo {

    /**
     * Получение информации из БД
     * @param infoId - id запрашиваемой инфы
     * @return - запрашиваемая инфа
     */
    Info getById(long infoId);

    /**
     * Получение списка информации из БД
     * @return - список информации из БД
     */
    List<Info> getAll();

    /**
     * Сохранение новой информации
     * @param info - новая сохраняемая информация
     */
    void save(Info info);

    /**
     * Удаление инфы
     * @param infoId - id удаляемой инфы
     */
    void delete(long infoId);

    /**
     * Редактирование инфы
     * @param info - редактируемая инфа
     */
    void edit(Info info);
}