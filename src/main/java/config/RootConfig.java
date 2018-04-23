package config;

import dao.DBConfig;
import dao.DBConfigDev;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.ServiceConfig;

/**
 * Бизнес-конфигурация приложения
 */
@Configuration
@ComponentScan(basePackageClasses = {DBConfig.class, ServiceConfig.class})
public class RootConfig {

}