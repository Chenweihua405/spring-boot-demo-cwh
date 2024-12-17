package org.example.strategy;

import org.springframework.stereotype.Service;

/**
 * @author 陈卫华
 * @date 2024/12/13
 */
@Service
public class CheckTaskService implements ITaskService{


    @Override
    public void executeTask() {
        System.out.println("执行审核任务");
    }

    @Override
    public String getType() {
        return TaskTypeEnum.CHECK_TASK.getType();
    }
}
