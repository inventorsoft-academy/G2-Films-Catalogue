package academy.inventorsoft.g2_films_catalogue.menu;


import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.user.User;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMenu {
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    FilmDataBase filmDataBase;
    public  void execute(User user) {
       consoleHelper.writeMessage("Welcome to user menu\n");


        /**
         * 1 View all films;
         * 0 View top 10 films;
         * 0 View top 10 directors;
         * 0 Make review for film;
         * 0 Vote for user’s review;
         * 0 View top voted reviews;
         * 1 View profile;
         * **/








        while (true) {
            consoleHelper.writeMessage(
                      " View film by name             - push [1]\n"
                    + " View all films                - push [2]\n"
                    + " View top 10 films             - push [3]\n"
                    + " View top 10 directors         - push [4]\n"
                    + " View top voted reviews        - push [5]\n"
                    + " View profile                  - push [6]\n"
                    + " Exit                          - push [0]\n");
            consoleHelper.writeMessage(" Please enter your choice:");
            switch (consoleHelper.readInt()) {
                case 1:
                    //TODO
                    continue;
                case 2:
                    consoleHelper.writeMessage("Films : ");

                    continue;
                case 3://TODO
                    continue;
                case 4: //TODO
                    continue;
                case 5: //TODO
                    continue;
                case 6: //TODO fix method

                    continue;
                case 0:
                    return;
                default:
                   consoleHelper.writeMessage("Wrong number of option, try again");
            }

        }


    }



}
