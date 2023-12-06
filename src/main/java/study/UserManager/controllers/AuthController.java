package study.UserManager.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.UserManager.DTOs.LoginDTO;
import study.UserManager.DTOs.RegisterDTO;
import study.UserManager.User;
import study.UserManager.services.UserService;

@AllArgsConstructor
@Getter
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final UserService userService;

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody LoginDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    private ResponseEntity register(@RequestBody User user){
        return userService.addNewUser(user);
    }
}
