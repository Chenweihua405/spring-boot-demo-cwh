package org.example;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author 陈卫华
 * @date 2024/11/11
 */
public class MsgUtil {
    private static MessageSource messageSource;

    public static void inti(MessageSource messageSource) {
        MsgUtil.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey) {
        try {
            String message = messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
            return message;
        } catch (Exception e) {
            return msgKey;
        }
    }
}
