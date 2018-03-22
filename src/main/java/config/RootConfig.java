package config;

import dao.DBConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.ServiceConfig;

/**
 * Бизнес-конфигурация приложения
 */
@Configuration
@ComponentScan(basePackageClasses = {DBConfig.class, ServiceConfig.class})
public class RootConfig {

}