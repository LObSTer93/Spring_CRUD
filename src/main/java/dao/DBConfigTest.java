package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@Profile("test")
public class DBConfigTest {

    @Bean
    public DataSource testDataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        return builder.
                setType(EmbeddedDatabaseType.H2).
                addScript("classpath:schema.sql").
                build();
    }
}