package config;

import Data.Repo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

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

    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
        return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}