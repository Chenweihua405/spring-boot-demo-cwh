package org.example.controller;

import org.example.bean.TestVo;
import org.example.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈卫华
 * @date 2024/12/9
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/test")
    public TestVo test(Long id) {
        return testService.test(id);
    }

}
