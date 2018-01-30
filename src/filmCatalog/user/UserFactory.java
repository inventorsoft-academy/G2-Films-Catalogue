package filmCatalog.user;



import filmCatalog.dataBase.UserDataBase;
import filmCatalog.menu.ModeratorMenu;
import filmCatalog.utilitClass.ConsoleHelper;
import filmCatalog.utilitClass.Validator;


/**
 * Created by Komatoz on 17.01.2018.
 */
public class UserFactory {
    private UserFactory() {
    }

    public static void createUser() {

        boolean done = true;
        ConsoleHelper.writeMessage("Welcome to registration new user\n");
        while (done) {
            boolean isAdmin = false;


            ConsoleHelper.writeMessage("Please enter your Login - email");
            String login = ConsoleHelper.readString();

            if (!Validator.isValidEmail(login)) {
                ConsoleHelper.writeMessage("Email is not correct");
                continue;
            }


            if (UserDataBase.hasUserInBase(login)) {
                ConsoleHelper.writeMessage("Sorry, but this login is busy");
                continue;
            }


            //TODO validation password
            ConsoleHelper.writeMessage("Please enter your password");
            String password = ConsoleHelper.readString();

            ConsoleHelper.writeMessage("Please enter your nickname");
            String nickName = ConsoleHelper.readString();


            ConsoleHelper.writeMessage("If you Moderator, please, write Yes.");
            if (ConsoleHelper.readString().equalsIgnoreCase("Yes")) {
                isAdmin = true;
            }



            ConsoleHelper.writeMessage("UserFactory account done");

            UserDataBase.addUser(new User(nickName, login, password, isAdmin));

            if (isAdmin) {
                ModeratorMenu.execute();
                return;
            } else return;      // TODO UserMenu;


        }

    }
}
