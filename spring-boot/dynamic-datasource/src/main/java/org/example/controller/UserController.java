package org.example.controller;

import org.example.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@RestController
public class UserController {

    @Autowired
    private IUserMapper userMapper;


    @GetMapping("/getusername")
    public String getUserNameById(Long id){
        return userMapper.getUserNameById(id);
    }

}
