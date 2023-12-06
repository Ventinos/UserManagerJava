package study.UserManager.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.UserManager.User;
import study.UserManager.services.UserService;

import java.util.List;


@AllArgsConstructor
@Getter
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

    @PutMapping
    public ResponseEntity updateUsername(@RequestBody User user){
        return userService.updateUsername(user.getEmail(), user.getUsername());
    }

//    @PutMapping
//    public ResponseEntity updateRole(@RequestBody User user){
//        return userService.updateRole(user.getEmail(), user.getRole().toString());
//    }

}
