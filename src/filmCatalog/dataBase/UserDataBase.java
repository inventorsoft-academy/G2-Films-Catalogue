package filmCatalog.dataBase;

import filmCatalog.user.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Komatoz on 30.01.2018.
 */
public class UserDataBase {
    private UserDataBase() {
    }

    private static List<User> users = DataBase.getUsers();

    static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }


    public static boolean hasUserInBase(String login) {
        return getAllUserLogin().stream().filter(p -> p.equalsIgnoreCase(login)).findFirst().isPresent();
    }

    public static List<String> getAllUserLogin() {
        return users.stream().map(User::getLoginEmail).collect(Collectors.toList());
    }

    public static User getUser(String login) {
        return users.stream().filter(p -> p.getLoginEmail().equalsIgnoreCase(login)).findFirst().get();
    }


}
