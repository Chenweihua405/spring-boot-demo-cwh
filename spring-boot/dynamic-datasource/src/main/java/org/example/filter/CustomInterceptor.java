package org.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.example.datasource.DSTypeContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈卫华
 * @date 2024/11/25
 */
@Slf4j
@Component
public class CustomInterceptor implements HandlerInterceptor {
    /**
     * 不需要统计耗时的地址
     */
    private static final List<String> EXCLUDE_URI = Arrays.asList("/cip-mkt-bid-web/heartbeat");
    /**
     * 开始时间记录
     */
    private ThreadLocal<Long> time = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求头中的language
        String language = request.getHeader("language");
        if ("zh_CN".equals(language)) {
            DSTypeContainer.setDataBaseType("master");
        } else {
            DSTypeContainer.setDataBaseType("slave_1");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}

