package com.example.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    // 기존 Spring MVC의 @Controller에서 @ResponseBody를 통해 데이터만을 전달했던 것과 달리, 자동으로 데이터만을 전달하는 것이다.
    // 즉, @RestController 와 @Controller 의 차이점은 'only 데이터 전달에 관심' vs 'view까지 다 만들어서 전달에 관심' 인 것이다.
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello, World!");
    }

    // {data}를 @PathVariable 로 받을 수 있다. 받는 이름이 다르다면 value 속성으로 지정해준다.
    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }
}
