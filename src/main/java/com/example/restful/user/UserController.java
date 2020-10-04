package com.example.restful.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAll() {
        return userDaoService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userDaoService.save(user);

        // 서버에서 만들어진 등록된 사용자 id를 응답으로 리턴함으로써, id를 알기 위한 추가적인 요청이 필요없어져 트래픽을 감소시킬 수 있다.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(retrieveOne(user.getId()).getId())
                .toUri();

        // 모든 성공한 요청을 200으로 처리하는게 아니라, 경우에 맞게 세분화해야한다.(created = 201)
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}")
    public User retrieveOne(@PathVariable int id) {
        return userDaoService.findOne(id);
    }
}
