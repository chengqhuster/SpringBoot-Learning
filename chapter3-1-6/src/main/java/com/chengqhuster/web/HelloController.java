package com.chengqhuster.web;

import com.chengqhuster.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "https://github.com/chengqhuster/SpringBoot-Learning");
        return "index";
    }

    @RequestMapping("/json")
    public String json() throws Exception{
        throw new MyException("发生错误");
    }

    @RequestMapping("/exception")
    public String errorPage() throws Exception{
        throw new Exception("发生错误");
    }
}
