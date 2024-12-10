package org.example.datasource;

import org.springframework.util.StringUtils;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
public class DSTypeContainer {
    private static final ThreadLocal<String> TYPE = new ThreadLocal<String>();

    public static String defaultType;

    /**
     * 往当前线程里设置数据源类型
     *
     * @param dataBase
     */
    public static void setDataBaseType(String dataBase) {
        if (StringUtils.isEmpty(dataBase)) {
            dataBase = defaultType;
        }
        TYPE.set(dataBase);
        System.err.println("[将当前数据源改为]：" + dataBase);
    }

    /**
     * 获取数据源类型
     *
     * @return
     */
    public static String getDataBaseType() {
        String database = TYPE.get();
        System.err.println("[获取当前数据源的类型为]：" + database);
        return database;
    }

    /**
     * 清空数据类型
     */
    public static void clearDataBaseType() {
        TYPE.remove();
    }
}