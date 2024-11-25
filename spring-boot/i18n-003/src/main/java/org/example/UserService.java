package org.example;

import org.springframework.stereotype.Service;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
@Service
public class UserService {

    @Datasource("usa")
    public void createUserUsa(User user) {
        // 使用usa数据库操作

    }

    @Datasource("china")
    public void createUserChina(User user) {
        // 使用china数据库操作

    }
}
