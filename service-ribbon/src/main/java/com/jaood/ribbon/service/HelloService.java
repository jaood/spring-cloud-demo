package com.jaood.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Esther on 2017/7/26
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        //通过restTemplate.getForObject方法，service-ribbon 就可以调用service-hi的方法了。并且在调用的工程中并之需要写服务的名，而不是具体的ip.
        return restTemplate.getForObject("http://SERVER-LOGIN/hi?name="+name,String.class);
    }

    //启用熔断器后调用的返回值
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
