package study.UserManager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.UserManager.User;
import study.UserManager.services.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PutMapping
    public void updateUsername(@RequestBody User user){
        userService.updateUsername(user.getEmail(), user.getUsername());
    }
}
