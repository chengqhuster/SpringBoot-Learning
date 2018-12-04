package com.chengqhuster.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String echo() {
        return "hello";
    }

    @GetMapping("/call-provider")
    public Object call(@RequestParam Integer a, @RequestParam Integer b) {
        Object result = restTemplate.getForObject("http://COMPUTE-SERVICE/add?a=" + a + "&b=" + b, Object.class);
        return result;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
