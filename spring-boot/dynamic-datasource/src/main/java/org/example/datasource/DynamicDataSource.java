package org.example.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @author 陈卫华
 * @date 2024/11/25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String dataBaseType = DSTypeContainer.getDataBaseType();
        return dataBaseType;
    }
}