package academy.inventorsoft.g2_films_catalogue.user;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by Komatoz on 15.01.2018.
 */
@Getter
@NoArgsConstructor
public class User{
    private String nickName;
    private String loginEmail;
    private String password;
    private boolean moderator;

    @JsonCreator
    public User(@JsonProperty("nickName") String nickName,@JsonProperty("loginEmail") String loginEmail,@JsonProperty("password") String password,@JsonProperty("moderator") boolean moderator) {
        this.nickName = nickName;
        this.loginEmail = loginEmail;
        this.password = password;
        this.moderator = moderator;
    }





    public String convertUserToString() {
        String result = this.nickName + "<UserTag%>"
                + this.loginEmail + "<UserTag%>"
                + this.password + "<UserTag%>"
                + this.moderator + "<UserTag%>\n";
        return result;
    }


    public static User loadUser(String file) {
        String[] s = file.split("<UserTag%>");
        String nickName = s[0];
        String loginEmail = s[1];
        String password = s[2];
        boolean isModerator = Boolean.parseBoolean(s[3]);

        return new User(nickName, loginEmail, password, isModerator);

    }
}
