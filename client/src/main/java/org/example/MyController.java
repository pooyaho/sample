package org.example;


import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

@RestController
public class MyController {

    @Autowired
    private Validator smartValidator;

    @GetMapping
    public MyDto sayHello() throws InterruptedException {
        MyDto myDto = new MyDto();
        myDto.setContent("Hello world!");

        MyClass myClass = new MyClass();
        Set<ConstraintViolation<MyClass>> validate = smartValidator.validate(myClass);

        return myDto;
    }
}


class MyClass {
    @ContactNumberConstraint(message = "12213", num = 12)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

