package org.example;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class MyService {

    @Autowired
    private MessageSource messageSource;

    public String getLocalizedMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }
}
