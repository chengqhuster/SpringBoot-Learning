package com.chengqhuster.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("COMPUTE-SERVICE")
public interface ComputeServiceClient {

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
