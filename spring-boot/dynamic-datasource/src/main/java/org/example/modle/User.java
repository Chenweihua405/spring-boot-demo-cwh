package org.example.modle;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@Data
@TableName("tb_user")
public class User {

    /**
     * 私有字段id，存储唯一标识符
     * 该字段为Long类型，用于唯一标识一个实体对象
     */
    private Long id;

    /**
     * 私有字段name，存储名称
     * 该字段为String类型，用于记录实体对象的名称
     */
    private String name;

    /**
     * 私有字段age，存储年龄
     * 该字段为Integer类型，用于记录实体对象的年龄
     */
    private Integer age;

}
