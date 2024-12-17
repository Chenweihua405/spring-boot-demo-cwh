package org.example.strategy;

/**
 * @author 陈卫华
 * @date 2024/12/16
 */
import org.springframework.stereotype.Service;

@Service
public class TaskExecutorService {

    public void executeTask(String taskName) {
        // 获取任务服务
        ITaskService taskService = TaskContainer.getTaskService(taskName);
        if (taskService == null) {
            throw new IllegalArgumentException("Unknown task: " + taskName);
        }

        // 执行任务
        taskService.executeTask();
    }
}