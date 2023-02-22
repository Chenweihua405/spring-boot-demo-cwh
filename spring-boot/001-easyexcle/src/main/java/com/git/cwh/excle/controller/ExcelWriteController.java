package com.git.cwh.excle.controller;

/**
 * @author cwh
 * @version 1.0.0
 * @ClassName ExcelWriteController.java
 * @Description TODO
 * @createTime 2023年02月21日 17:27:00
 */
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.git.cwh.excle.entity.UserEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/excle")
public class ExcelWriteController{


    /**
     * 测试写入Excel文件
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/download")
    public void doDownLoad(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("第一个文件", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), UserEntity.class).sheet("模板").doWrite(getData());
    }

    /**
     * 构造假数据，实际上应该从数据库查出来
     *
     * @return List<UserEntity>
     */
    private List<UserEntity> getData(){
        List<UserEntity> users = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            UserEntity user = new UserEntity();
            user.setBirthday(new Date());
            user.setName("user_" + i);
            user.setSalary(1.285 * i);
            user.setTelphone("1888888888" + i);
            users.add(user);
        }
        return users;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

}