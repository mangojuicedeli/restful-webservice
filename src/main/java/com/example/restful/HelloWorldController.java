package com.example.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // 일반 String 타입으로 리턴하는 경우
    // 스프링 4 이전의 @RequestMapping의 method 속성으로 지정해주는 것보다 직관적이다.
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello, World!";
    }

    // @RestController는 리턴 타입을 java bean으로 하면, 자동으로 json 형식으로 리턴한다.
    // ResponseBody에 데이터를 담아 전달할 수도 있지만, 이렇게 java bean으로 데이터만을 전달도 가능하다.
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello, World!");
    }
}
