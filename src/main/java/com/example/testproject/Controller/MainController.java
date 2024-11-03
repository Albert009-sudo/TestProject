package com.example.testproject.Controller;


import com.example.testproject.Entity.security.User;
import com.example.testproject.Service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final UserService userService;

    @PostMapping("/register")
    public void welcome( @RequestBody User user){
        userService.registerUser(user);
    }


}
