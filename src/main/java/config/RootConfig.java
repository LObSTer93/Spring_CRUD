package config;

import dao.DBConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Бизнес-конфигурация приложения
 */
@Configuration
@ComponentScan(basePackageClasses = DBConfig.class)
public class RootConfig {

}