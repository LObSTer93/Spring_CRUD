package Data;

import lombok.Builder;
import lombok.Getter;

/**
 * Данные в БД
 */
@Builder
public class Info {

    @Getter
    private long id;
    @Getter
    private String name;
    @Getter
    private String eMail;
}