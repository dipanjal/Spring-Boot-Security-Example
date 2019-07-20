package com.example.oauth.test.configs.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.example.oauth.test.repository")
public class MySqlConfig {

    @Value("${db.driver}")
    private String DB_DRIVER_CLASS;
    @Value("${spring.datasource.url}")
    private String DB_URL;
    @Value("${spring.datasource.username}")
    private String DB_USER;
    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String HIBERNATE_DIALECT;
    @Value("${db.sql.show}")
    private String HIBERNATE_SHOW_SQL = "true";
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String HBM2DDL_AUTO;

    private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "com.example.oauth.test.models.entity";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER_CLASS);
        dataSource.setUrl(DB_URL);     //MySQL Specific: +"?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false"
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
        hibernateProperties.put("hibernate.enable_lazy_load_no_trans", true);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
        factory.setDataSource(getDataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }


}
