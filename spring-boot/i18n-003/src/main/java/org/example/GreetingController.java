package org.example;

/**
 * @author 陈卫华
 * @date 2024/11/13
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingController {

    @Autowired
    private MyService myService;

    @GetMapping("/greeting")
    public String greet(@RequestParam(value = "lang", required = false) Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return myService.getLocalizedMessage("hello", locale);
    }

//    @GetMapping("/welcome")
//    public String welcome(@RequestParam(value = "lang", required = false) String name,
//                          @RequestParam(value = "lang", required = false) Locale locale) {
//        if (locale == null) {
//            locale = Locale.getDefault();
//        }
//        return myService.getLocalizedMessage("welcome", new Object[]{name}, locale);
//    }
}

