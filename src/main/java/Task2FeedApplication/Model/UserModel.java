package Task2FeedApplication.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserModel {
    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private Set<String> roles;
}
