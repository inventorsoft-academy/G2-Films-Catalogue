package film;

import film.dataBase.DataBase;

import java.util.*;

/**
 * Created by Komatoz on 17.01.2018.
 */
public abstract class Authorization {
    private static ArrayList<User> users= new ArrayList<>();


    public static boolean isUser(String login){
        for (String userName : DataBase.getAllUserNames()) {
            if (userName.equalsIgnoreCase(login))return true;

        }

        return false;
    }

    public static boolean validPass(String login, String password){
        for (User user : users) {
            if (user.getLogin_email().equalsIgnoreCase(login) &
                    user.getPassword().equals(password))
                return true;

        }

        return false;
    }

    
    public static User getUser(String login){
        for (User user : users) {
            if (user.getLogin_email().equalsIgnoreCase(login))return user;
        }
        return null;
    }











}
