package academy.inventorsoft.g2_films_catalogue.dataBase;


import academy.inventorsoft.g2_films_catalogue.model.User;
import org.springframework.stereotype.Component;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Komatoz on 30.01.2018.
 */
@Component
public class UserDataBase{

    private List<User> users;
    DataBase dataBase;

    public UserDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
        users = dataBase.getUsers();
    }



    List<User> getUsers() {
        return users;
    }

    public  void addUser(User user) {
        users.add(user);
    }

    public boolean isUser(String login, String password){
        return getUser(login).filter(p->p.getPassword().equalsIgnoreCase(password)).isPresent();
    }
    public  boolean hasUserInBase(String login) {
        return getAllUserLogin().stream().anyMatch(p -> p.equalsIgnoreCase(login));
    }

    public  List<String> getAllUserLogin() {
        return users.stream().map(User::getLoginEmail).collect(Collectors.toList());
    }

    public Optional<User> getUser(String login) {
        return users.stream()
                .filter(p->p.getLoginEmail()
                        .equalsIgnoreCase(login)).findFirst();

    }

    public boolean isModerator(String login){
        return hasUserInBase(login) && getUser(login).get().isModerator();
    }

    public void saveData() {
        dataBase.saveAllUsersToFile(users);
    }
}
