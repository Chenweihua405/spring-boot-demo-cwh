package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.bean.TestVo;
import org.example.entity.Test;

/**
 * @author 陈卫华
 * @date 2024/12/9
 */
public interface ITestMapper extends BaseMapper<Test> {

    TestVo getTest(Long id);

}
