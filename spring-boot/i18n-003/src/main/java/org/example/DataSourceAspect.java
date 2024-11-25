package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
@Aspect
@Component
public class DataSourceAspect {
    @Before("@annotation(datasource)")
    public void switchDataSource(JoinPoint point, Datasource datasource) {
        DynamicDataSource.setDataSourceType(datasource.value());
    }

    @After("@annotation(datasource)")
    public void restoreDataSource(JoinPoint point, Datasource datasource) {
        DynamicDataSource.setDataSourceType("primary");
    }
}
