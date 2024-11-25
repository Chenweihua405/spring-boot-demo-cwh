package org.example;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class ProductController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Long id, @RequestHeader(value = "Accept-Language", required = false) String language) {
        Locale locale = Locale.forLanguageTag(language);
        String message = messageSource.getMessage("productNotFound", null, locale);
        return message;
    }
}

