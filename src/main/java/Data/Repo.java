package Data;

import java.util.List;

/**
 * Достаёт данные из БД
 */
public interface Repo {
    List<Info> getInfo();
}