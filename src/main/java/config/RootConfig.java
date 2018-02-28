package config;

import Data.Repo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Бизнес-конфигурация приложения
 */
@Configuration
@ComponentScan(basePackageClasses = Repo.class)
public class RootConfig {

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.
                setType(EmbeddedDatabaseType.H2).
                addScript("classpath:schema.sql").
                addScript("classpath:data.sql").
                build();
    }
}