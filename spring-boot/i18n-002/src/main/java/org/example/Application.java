package org.example;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * @author 陈卫华
 * @date 2024/11/11
 */
@Controller
@SpringBootApplication
public class Application {

    public Application(MessageSource messageSource) {
        MsgUtil.inti(messageSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Data
    @Accessors(chain = true)
    public static class RspWrapper<T> {
        private int code;
        private String msg;
        private T data;
    }

    @GetMapping(path = "change")
    @ResponseBody
    public String changeLocal(String language) {
        String[] s = language.split("_");
        LocaleContextHolder.setLocale(new Locale(s[0], s[1]));
        RspWrapper res = new RspWrapper<>().setCode(200).setMsg(MsgUtil.get("200")).setData(true);
        return JSON.toJSONString(res);
    }

    @GetMapping(path = "change2")
    @ResponseBody
    public String changeLocal2(String language) {
        String[] s = language.split("_");
        LocaleContextHolder.setLocale(new Locale(s[0], s[1]));

        RspWrapper res = new RspWrapper<>().setCode(200).setMsg(MsgUtil.get("200")).setData(true);
        return JSON.toJSONString(res);
    }

    @GetMapping(path = "change3")
    @ResponseBody
    public String changeLocal3(String language) {
        String[] s = language.split("_");
        LocaleContextHolder.setLocale(new Locale(s[0], s[1]));
        RspWrapper res = new RspWrapper<>().setCode(200).setMsg(MsgUtil.get("200")).setData(true);
        return JSON.toJSONString(res);
    }


    @GetMapping(path = "say")
    @ResponseBody
    public String say(String name) {
        RspWrapper res = new RspWrapper<>().setCode(200).setMsg(MsgUtil.get("200")).setData(MsgUtil.get("name") + ":" + name);
        return JSON.toJSONString(res);
    }

    @GetMapping(path = "say2")
    @ResponseBody
    public String say2(String name) {
        RspWrapper res = new RspWrapper<>().setCode(200).setMsg(MsgUtil.get("200")).setData(MsgUtil.get("name") + ":" + name);
        return JSON.toJSONString(res);
    }

    @GetMapping(path = {"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("name", MsgUtil.get("name"));
        model.addAttribute("pwd", MsgUtil.get("pwd"));
        return "index";
    }


}
