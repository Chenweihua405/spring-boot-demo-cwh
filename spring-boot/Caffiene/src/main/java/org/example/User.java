package org.example;

import lombok.Data;

/**
 * @author 陈卫华
 * @date 2024/11/22
 */
@Data
public class User {

    /**
     * 用户id
     */
    public Integer uid;

    /**
     * 用户名称
     */
    public String name;

    User(Integer uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    User() {

    }


}
