package filmCatalog.user;


/**
 * Created by Komatoz on 15.01.2018.
 */
public class User{
    private final String nickName;
    private final String loginEmail;
    private final String password;
    private final boolean isModerarot;

    public User(String nickName, String loginEmail, String password, boolean isModerarot) {
        this.nickName = nickName;
        this.loginEmail = loginEmail;
        this.password = password;
        this.isModerarot = isModerarot;
    }


    public String getNickName() {
        return nickName;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public String getPassword() {
        return password;
    }

    public boolean isModerarot() {
        return isModerarot;
    }

    @Override
    public String toString() {
        return "user{" + "nickname='" + nickName + '\'' + ", loginEmail='" + loginEmail + '\'' + ", password='" + password + '\'' + ", isModerarot=" + isModerarot + '}';
    }



    public String saveUser() {
        String result = this.nickName + "<UserTag%>"
                + this.loginEmail + "<UserTag%>"
                + this.password + "<UserTag%>"
                + this.isModerarot + "<UserTag%>\n";
        return result;
    }


    public static User loadUser(String file) {
        String[] s = file.split("<UserTag%>");
        String nickName = s[0];
        String LoginEmail = s[1];
        String password = s[2];
        boolean isModerator = Boolean.parseBoolean(s[3]);

        return new User(nickName, LoginEmail, password, isModerator);

    }
}
