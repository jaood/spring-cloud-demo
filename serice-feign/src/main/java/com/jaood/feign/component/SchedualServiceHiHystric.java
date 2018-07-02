package com.jaood.feign.component;

import com.jaood.feign.itf.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by Esther on 2017/7/26
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
