package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modle.User;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {
    /**
     * 根据id获取用户名
     * @param id
     * @return string
     */
    String getUserNameById(Long id);

}
