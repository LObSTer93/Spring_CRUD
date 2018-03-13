package dao;

import lombok.*;

/**
 * Данные в БД
 */
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String eMail;
}