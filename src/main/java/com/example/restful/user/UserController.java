package com.example.restful.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAll() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveOne(@PathVariable int id) {
        return userDaoService.findOne(id);
    }
}
