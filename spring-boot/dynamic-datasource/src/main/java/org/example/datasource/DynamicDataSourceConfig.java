package org.example.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@Configuration
@EnableConfigurationProperties(DSProperties.class)
@MapperScan(basePackages = {"org.example.mapper"},
        sqlSessionFactoryRef = "SqlSessionFactory")
public class DynamicDataSourceConfig {

    @SuppressWarnings("unchecked")
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(DSProperties dsProperties) {
        Map targetDataSource = new HashMap<>(8);
        dsProperties.getDatasource().forEach((k, v) -> {
            targetDataSource.put(k, v.initializeDataSourceBuilder().build());
        });
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);

        // 设置默认的数据库，下面这个赋值方式写法不太推荐，这里只是为了方便而已
        DSTypeContainer.defaultType = (String) targetDataSource.keySet().stream().findFirst().get();
        dataSource.setDefaultTargetDataSource(targetDataSource.get(DSTypeContainer.defaultType));
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:/org/example/mapper/*Mapper.xml"));
        return bean.getObject();
    }
}