package academy.inventorsoft.g2_films_catalogue.menu;


import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.dataBase.UserDataBase;
import academy.inventorsoft.g2_films_catalogue.dataBase.UserReviewDataBase;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import academy.inventorsoft.g2_films_catalogue.utilitClass.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Komatoz on 27.01.2018.
 */
@Component
public class AuthorizationMenu {
    @Autowired
    private UserDataBase userDataBase;
    @Autowired
    private FilmDataBase filmDataBase;
    @Autowired
    private UserReviewDataBase userReviewDataBase;
    /*@Autowired
    private UserFactory userFactory;*/
    @Autowired
    private Validator validator;
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    ModeratorMenu moderatorMenu;
    @Autowired
    UserMenu userMenu;


    private AuthorizationMenu(){}
    public  void execute() {
       consoleHelper.writeMessage("Hello Bro! we welcome You in this site. \n\n Do you want to register or authorize?\n");
        while (true) {




            consoleHelper.writeMessage(" Authorize - push [1]\n Register  - push [2]\n Exit      - push [0]\n");
          consoleHelper.writeMessage(" Please enter your choice:");

            switch (consoleHelper.readInt()) {
                case 1:
                    if( userDataBase.getAllUserLogin().isEmpty()){
                        consoleHelper.writeMessage("OOPS you are first user in this site, go to registration");
                        continue;
                    }
                    break;
                case 2:
                    /*userFactory.createUser();
                    continue;*/
                case 0:
                    return;
                default:
                    consoleHelper.writeMessage("Wrong number of option, try again");
                    continue;
            }



            consoleHelper.writeMessage("Please write your login - email:");
            String login = consoleHelper.readString();

            while(!userDataBase.hasUserInBase(login)){
                consoleHelper.writeMessage("There is no user with such name, try again or write exit");
                login =consoleHelper.readString();
                if (login.equalsIgnoreCase("exit")) return;
            }
           consoleHelper.writeMessage("Please write your password:");
            String pass = consoleHelper.readString();
            if (!validator.validPassOfUser(login, pass)) {
                consoleHelper.writeMessage("There is no such combination of login and password. Try again");
            }





        }




    }

 /*   @Override
    public void run(String... strings) throws Exception {
        execute();
     userDataBase.saveData();
     filmDataBase.saveData();
     userReviewDataBase.saveData();

    }*/
}
