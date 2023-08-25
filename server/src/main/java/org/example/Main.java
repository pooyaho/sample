package org.example;

import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Main implements ApplicationRunner {





    @Autowired
    private FeignStub feignStub;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            System.out.println(feignStub.sayHell());
        } catch (RetryableException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}