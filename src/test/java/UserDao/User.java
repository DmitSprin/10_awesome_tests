package UserDao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class User  {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;


}