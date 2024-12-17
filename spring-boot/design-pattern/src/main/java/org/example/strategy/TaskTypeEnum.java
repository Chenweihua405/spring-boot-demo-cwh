package org.example.strategy;


/**
 * @author 陈卫华
 * @date 2024/12/13
 */

public enum TaskTypeEnum {

    CHECK_TASK("check_task", "审核任务"),

    SEND_TASK("send_task", "发送任务");

    private String type;

    private String desc;

    TaskTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDesc(String type) {
        for (TaskTypeEnum taskTypeEnum : TaskTypeEnum.values()) {
            if (taskTypeEnum.getType().equals(type)) {
                return taskTypeEnum.getDesc();
            }
        }
        return null;
    }
}
