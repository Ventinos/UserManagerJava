package study.UserManager.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.UserManager.User;
import study.UserManager.repos.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
           throw new IllegalStateException("Email has been taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        boolean exists = userRepository.existsByEmail(user.getEmail());
        if (!exists) {
            throw new IllegalStateException("This user isn't registered!");
        }
        userRepository.delete(user);
    }

    @Transactional
    public void updateUsername(String email, String username){
        //yes, lambda function!
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalStateException("User not registered!"));
        user.setUsername(username);
    }
}
