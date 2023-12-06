package study.UserManager.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import study.UserManager.User;
import study.UserManager.UserRole;
import study.UserManager.repos.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity addNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
           return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteUser(User user) {
        boolean exists = userRepository.existsByEmail(user.getEmail());
        if (!exists) {
            return ResponseEntity.badRequest().build();
        }
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity updateUsername(String email, String username){
        User user = userRepository.findUserByEmail(email).orElse(null);

        if (user==null)
            return ResponseEntity.badRequest().build();

        user.setUsername(username);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity updateRole(String email, String role){
        User user = userRepository.findUserByEmail(email).orElse(null);

        if (user==null)
            return ResponseEntity.badRequest().build();

        user.setRole(UserRole.valueOf(role.toUpperCase()));
        return ResponseEntity.ok().build();
    }
}
