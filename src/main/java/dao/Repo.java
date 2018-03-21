package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Запросы к таблице info
 */
@Transactional
public interface Repo extends JpaRepository<Info, Long>{

    /**
     * Получение информации из БД
     * @param infoId - id запрашиваемой инфы
     * @return - запрашиваемая инфа
     */
    Info getById(long infoId);

    /**
     * Редактирование информации
     * @param name - новое имя
     * @param email - новый email
     * @param id - id заявки, которую хотим отредактировать
     */
    @Modifying
    @Query("update Info i set i.name=:name, i.email=:email where i.id=:id")
    void edit(@Param("name") String name, @Param("email") String email, @Param("id") long id);
}