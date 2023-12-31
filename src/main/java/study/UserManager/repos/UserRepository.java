package study.UserManager.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import study.UserManager.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findUserByEmail(String email);
    User getUserByEmail(String email);

    User getReferenceByEmail(String email);

    UserDetails getUserDetailsByEmail(String email);
    boolean existsByEmail(String email);
}
