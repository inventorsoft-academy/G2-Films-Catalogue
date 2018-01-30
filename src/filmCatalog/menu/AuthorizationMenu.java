package filmCatalog.menu;

import filmCatalog.dataBase.UserDataBase;
import filmCatalog.user.UserFactory;
import filmCatalog.utilitClass.ConsoleHelper;
import filmCatalog.utilitClass.Validator;

import static filmCatalog.utilitClass.ConsoleHelper.*;

/**
 * Created by Komatoz on 27.01.2018.
 */
public class AuthorizationMenu {
    private AuthorizationMenu(){}
    public static void execute() {
        writeMessage("Hello Bro! we welcome You in this site. \n\n Do you want to register or authorize?\n");
        boolean flag =true;
        while (flag) {




            writeMessage(" Authorize - push [1]\n Register  - push [2]\n Exit      - push [0]\n");
            writeMessage(" Please enter your choice:");

            switch (readInt()) {
                case 1:
                    if(UserDataBase.getAllUserLogin().isEmpty()){
                        ConsoleHelper.writeMessage("OOPS you are first user in this site, go to registration");
                        continue;
                    }
                    flag = false;
                    break;
                case 2:
                    UserFactory.createUser();
                    continue;
                case 0:
                    return;
                default:
                    writeMessage("Wrong number of option, try again");
            }



            writeMessage("Please write your login - email:");
            String login = readString();

            while(!UserDataBase.hasUserInBase(login)){
                ConsoleHelper.writeMessage("There is no user with such name, try again or write exit");
                login =ConsoleHelper.readString();
                if (login.equalsIgnoreCase("exit")) return;
            }
            writeMessage("Please write your password:");
            String pass = readString();
            if (!Validator.validPassOfUser(login, pass)) {
                writeMessage("There is no such combination of login and password. Try again");
            }else {
                if(UserDataBase.getUser(login).isModerarot()) {
                    ModeratorMenu.execute();
                    return;
                } else return;      // TODO UserMenu;
            }





        }




    }

}
