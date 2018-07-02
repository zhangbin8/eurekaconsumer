package com.yhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProvider")
    public Object getProvider() {
        //url中对应api提供者的名称，全大写
        return this.restTemplate.getForObject("http://xiaoming/getClientName", Object.class);
    }

    /**
     * 测试下外网，也就是如果域名是外网的，不在eureka注册服务中的，会怎样
     * @return
     */
    @GetMapping(value = "/test")
    public String test() {
        //url中对应api提供者的名称，全大写
        return restTemplate.getForEntity("http://www.baidu.com/", String.class).getBody();
    }
}
