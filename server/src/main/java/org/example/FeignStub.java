package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign.client",url = "http://localhost:8080/")
public interface FeignStub {
    @GetMapping("/")
    MyClass sayHell();

}
