// src/main/java/com/example/demo/controller/UserController.java
package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    // 샘플 사용자 데이터
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("1001", new User("1001", "John Doe"));
        users.put("1002", new User("1002", "Jane Smith"));
        // 필요한 경우 더 많은 사용자 추가 가능
    }

    // GET 방식으로 사번에 따른 사용자 정보 조회 API
    @GetMapping("/api/v1/user")
    public User getUser(@RequestParam String id) {
        if (users.containsKey(id)) {
            return users.get(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
