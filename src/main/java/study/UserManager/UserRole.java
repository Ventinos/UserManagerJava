package study.UserManager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private String role;
}
