package dao;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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