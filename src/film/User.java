package film;

/**
 * Created by Komatoz on 15.01.2018.
 */
public class User {
    private final String nickName;
    private final String login_email;
    private final String password;
    private final boolean isAdministrator;

    public User(String nickName,
                String login_email,
                String password,
                boolean isAdministrator) {
        this.nickName = nickName;
        this.login_email = login_email;
        this.password = password;
        this.isAdministrator = isAdministrator;
    }


    public String getNickName() {
        return nickName;
    }

    public String getLogin_email() {
        return login_email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    @Override
    public String toString() {
        return "User{" + "nickname='" + nickName + '\'' + ", login_email='" + login_email + '\'' + ", password='" + password + '\'' + ", isAdministrator=" + isAdministrator + '}';
    }
}
