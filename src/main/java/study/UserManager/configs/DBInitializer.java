package study.UserManager.configs;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import study.UserManager.User;
import study.UserManager.UserRole;
import study.UserManager.repos.UserRepository;

@Component
@AllArgsConstructor
public class DBInitializer {
    @Autowired
    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        String encryptedPassword = new BCryptPasswordEncoder().encode("admin123");
        User user = new User("admin@mail.com","admin",encryptedPassword, UserRole.ADMIN);
        userRepository.save(user);
    }
}
