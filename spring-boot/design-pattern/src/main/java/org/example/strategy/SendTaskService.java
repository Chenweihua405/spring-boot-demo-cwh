package org.example.strategy;

import org.springframework.stereotype.Service;

/**
 * @author 陈卫华
 * @date 2024/12/13
 */
@Service
public class SendTaskService implements ITaskService{
    public void executeTask() {
        System.out.println("执行发送任务");
    }

    public String getType() {
        return TaskTypeEnum.SEND_TASK.getType();
    }

}
