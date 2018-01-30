package filmCatalog.utilitClass;

import filmCatalog.dataBase.DataBase;
import filmCatalog.dataBase.UserDataBase;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Komatoz on 28.01.2018.
 */
public class Validator {
    private Validator(){}
    public static boolean isNumber(String string) {
        string = string.trim();
        char[] ch = string.toCharArray();
        if (!validationEmptyFild(string)) {
            return false;
        }
        for (Character character : ch) {
            if (character < 48 || character > 57) {
                ConsoleHelper.writeMessage("No Bro. Only number :) \n One more time please");
                return false;
            }

        }

        return true;


    }

    public static boolean validationEmptyFild(String string) {
        if (string.equals(" ") || string.equals("")) {
            ConsoleHelper.writeMessage("Your text is empty, try again");
            return false;
        } else return true;


    }


    public static boolean isValidEmail(String email) {

        final Pattern pattern = Pattern.compile("^[A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}");
        final Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validPassOfUser(String login, String password) {
        return Optional.ofNullable(UserDataBase.getUser(login)).filter(p -> p.getPassword().equals(password)).isPresent();
    }
}
