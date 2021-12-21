package UserDao;

public class User implements IName,INumber,IEmail,IPassword,IUserBuild,IUser {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;


    public static IName get(){
        return  new User();
    }

    @Override
    public INumber setName(String name) {
        userName = name;
        return this;
    }

    @Override
    public IEmail setNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public IPassword setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public IUserBuild setPassword(String passwrd) {
        this.password = passwrd;
        return this;
    }

    @Override
    public IUser build() {
        return this;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public String getPhone() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

interface IUser{
    String getName();
    String getPhone();
    String getEmail();
    String getPassword();

}

interface IName{
    INumber setName(String name);
}
interface INumber{
    IEmail setNumber(String mail);
}
interface IEmail{
    IPassword setEmail(String email);
}
interface IPassword{
    IUserBuild setPassword(String passwrd);
}

interface IUserBuild {

    IUser build();
}