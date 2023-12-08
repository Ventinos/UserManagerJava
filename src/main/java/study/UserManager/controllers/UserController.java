package study.UserManager.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.UserManager.DTOs.UpdatePasswordDTO;
import study.UserManager.DTOs.UpdateRoleDTO;
import study.UserManager.DTOs.UpdateUsernameDTO;
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

    @PostMapping
    public ResponseEntity postUser(@RequestBody User user) { return userService.addNewUser(user); }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

    @PutMapping("update/username")
    public ResponseEntity updateUsername(@RequestBody UpdateUsernameDTO data){
        return userService.updateUsername(data.email(),data.newUsername());
    }

    @PutMapping("update/role")
    public ResponseEntity updateRole(@RequestBody UpdateRoleDTO data){
        return userService.updateRole(data.email(), data.newRole());
    }

    @PutMapping("update/password")
    public ResponseEntity updatePassword(@RequestBody UpdatePasswordDTO data){
        return userService.updatePassword(data.email(), data.newPassword());
    }
}
