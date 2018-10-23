package com.chengqhuster.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlogProperties {

    @Value("${com.chengqhuster.blog.name}")
    private String name;
    @Value("${com.chengqhuster.blog.title}")
    private String title;
    @Value("${com.chengqhuster.blog.desc}")
    private String desc;

    @Value("${com.chengqhuster.blog.value}")
    private String value;
    @Value("${com.chengqhuster.blog.number}")
    private Integer number;
    @Value("${com.chengqhuster.blog.bignumber}")
    private Long bignumber;
    @Value("${com.chengqhuster.blog.test1}")
    private Integer test1;
    @Value("${com.chengqhuster.blog.test2}")
    private Integer test2;
}
