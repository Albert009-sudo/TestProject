package com.example.testproject.Controller;

import com.example.testproject.Entity.security.User;
import com.example.testproject.Service.security.SecurityService;
import com.example.testproject.Service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("current")
    public User getCurrentUser() {
        return userService.getAuthorisedUser();
    }

    @PutMapping("current")
    public User edit(  @RequestBody User user) {
        long id= SecurityService.getCurrentUserId();
        return userService.edit(id, user);
    }


    @PostMapping("/change-password")
    public void changePassword(@RequestParam String oldPassword,@RequestParam String newPassword){
        userService.changePassword(oldPassword,newPassword);
    }
}
