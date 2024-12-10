package org.example.datasource;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.dynamic")
public class DSProperties {
    private Map<String, DataSourceProperties> datasource;
}