package org.example;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
public class DynamicDataSource extends AbstractRoutingDataSource {

    public static void setDataSourceType(String dataSourceType) {
        DataSourceContextHolder.setDataSourceType(dataSourceType);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}

