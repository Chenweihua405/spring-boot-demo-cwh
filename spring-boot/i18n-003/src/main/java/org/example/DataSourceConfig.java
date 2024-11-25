package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("primary", primaryDataSource());
        targetDataSources.put("usa", usaDataSource());
        targetDataSources.put("china", chinaDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());
        return dynamicDataSource;
    }

    @Bean
    public DataSource primaryDataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/default_db?useSSL=false", "root", "root");
    }

    @Bean
    public DataSource usaDataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/en_db?useSSL=false", "root", "root");
    }

    @Bean
    public DataSource chinaDataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/cn_db?useSSL=false", "root", "root");
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

}
