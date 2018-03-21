package dao;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Данные в БД
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Info {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private long id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String email;
}