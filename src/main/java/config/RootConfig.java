package config;

import Data.Repo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Бизнес-конфигурация приложения
 */
@Configuration
@ComponentScan(basePackageClasses = Repo.class)
public class RootConfig {
}