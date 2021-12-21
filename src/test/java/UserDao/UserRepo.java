package UserDao;



import org.testng.annotations.Test;

import static net.andreinc.mockneat.types.enums.StringType.NUMBERS;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;
import static net.andreinc.mockneat.unit.user.Passwords.passwords;

public class UserRepo extends User {


public static  User getExistUser(){
    String email = "admin1546@gmail.com";
    String name = "Dima";
    String password = "6748Admin";
    String phone = "664725156";

    return (User) User.get().setName(name).setNumber(phone).setEmail(email).setPassword(password);

}




    public static User createNewUser(){
         String  email = emails().get();
         String  password = passwords().get();
         String  name =  names().get();
         String phone = "+380" + strings()
                .size(10)
                .type(NUMBERS)
                .get();

      return (User) User.get().setName(name).setNumber(phone).setEmail(email).setPassword(password).build();

    }


    public void test(){
        String i =UserRepo.createNewUser().getName();
        System.out.println(i);
    }
}
