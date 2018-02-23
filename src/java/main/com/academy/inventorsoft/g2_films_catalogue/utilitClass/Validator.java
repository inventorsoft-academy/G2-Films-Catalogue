package academy.inventorsoft.g2_films_catalogue.utilitClass;



import academy.inventorsoft.g2_films_catalogue.dataBase.UserDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Komatoz on 28.01.2018.
 */
@Component
public class Validator {
    @Autowired
    private UserDataBase userDataBase;

    private Validator() {
    }

    public static boolean isNumber(String string) {
        string = string.trim();

        if (validationEmptyField(string)) {
            return false;
        }

        char[] ch = string.toCharArray();
        for (Character character : ch) {
            if (character < 48 || character > 57) {
                return false;
            }

        }

        return true;


    }

    public static boolean validationEmptyField(String string) {
        return string.trim().equalsIgnoreCase("");
    }


    public static boolean isValidEmail(String email) {

        final Pattern pattern = Pattern.compile("^[A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}");
        final Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    public  boolean validPassOfUser(String login, String password) {
        return userDataBase.getUser(login).get().getPassword().equalsIgnoreCase(password);


             /*   userDataBase.getUser(login))
                .filter(p -> p.getPassword().equals(password)).isPresent();*/
    }
}
