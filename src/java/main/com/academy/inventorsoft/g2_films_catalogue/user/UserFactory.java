package academy.inventorsoft.g2_films_catalogue.user;

import academy.inventorsoft.g2_films_catalogue.dataBase.UserDataBase;
import academy.inventorsoft.g2_films_catalogue.menu.ModeratorMenu;
import academy.inventorsoft.g2_films_catalogue.menu.UserMenu;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import academy.inventorsoft.g2_films_catalogue.utilitClass.Validator;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Komatoz on 17.01.2018.
 */

public class UserFactory {
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    private UserDataBase userDataBase;
    @Autowired
    ModeratorMenu moderatorMenu;
    @Autowired
    UserMenu userMenu;

    private UserFactory(UserDataBase userDataBase) {
        this.userDataBase =userDataBase;
    }

    public  void createUser() {

        boolean done = true;
        consoleHelper.writeMessage("Welcome to registration new user\n");
        while (done) {
            boolean isModerator = false;


            consoleHelper.writeMessage("Please enter your Login - email");
            String login = consoleHelper.readString();

            if (!Validator.isValidEmail(login)) {
                consoleHelper.writeMessage("Email is not correct");
                continue;
            }


            if (userDataBase.hasUserInBase(login)) {
                consoleHelper.writeMessage("Sorry, but this login is busy");
                continue;
            }


            //TODO validation password
            consoleHelper.writeMessage("Please enter your password");
            String password = consoleHelper.readString();

            consoleHelper.writeMessage("Please enter your nickname");
            String nickName = consoleHelper.readString();


            consoleHelper.writeMessage("If you Moderator, please, write Yes.");
            if (consoleHelper.readString().equalsIgnoreCase("Yes")) {
                isModerator = true;
            }



            consoleHelper.writeMessage("UserFactory account done");
            User user = new User(nickName, login, password, isModerator);
            userDataBase.addUser(user);

            if (isModerator) {
                moderatorMenu.execute();
                return;
            } else userMenu.execute(user);


        }

    }
}
