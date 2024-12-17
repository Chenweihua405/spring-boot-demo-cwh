package org.example.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 陈卫华
 * @date 2024/12/16
 */
@Component
public class TaskContainer implements ApplicationContextAware {

    private static  Map<String, ITaskService> taskServiceMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ITaskService> beansOfType = applicationContext.getBeansOfType(ITaskService.class);
        beansOfType.forEach((k, v) -> taskServiceMap.put(v.getType(), v));
    }

    public static ITaskService getTaskService(String type) {
        return taskServiceMap.get(type);
    }

}
