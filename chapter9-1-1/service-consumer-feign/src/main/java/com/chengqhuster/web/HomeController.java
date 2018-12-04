package com.chengqhuster.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ComputeServiceClient computeServiceClient;

    @GetMapping("/")
    public String echo() {
        return "hello";
    }

    @GetMapping("/call-provider")
    public Object call(@RequestParam Integer a, @RequestParam Integer b) {
        Object result = computeServiceClient.add(a, b);
        return result;
    }

}
