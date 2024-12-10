package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.bean.TestVo;
import org.example.mapper.ITestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陈卫华
 * @date 2024/12/9
 */
@Slf4j
@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    private ITestMapper testMapper;

    @Override
    public TestVo test(Long id) {
        return testMapper.getTest(id);
    }

}
