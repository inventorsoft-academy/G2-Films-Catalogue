package academy.inventorsoft.g2_films_catalogue.menu;


import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.film.FilmsFactory;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Komatoz on 28.01.2018.
 */
@Component
public class ModeratorMenu {
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    FilmDataBase filmDataBase;
    @Autowired
    FilmsFactory filmsFactory;
    public  void execute() {
        consoleHelper.writeMessage("Welcome to moderator menu\n");


        while (true) {
            consoleHelper.writeMessage(" Add new Film               - push [1] \n" + " View all films             - push [2]\n" + " Export top 10 films rating - push [3]\n" + " Exit                       - push [0]\n");
            consoleHelper.writeMessage(" Please enter your choice:");
            switch (consoleHelper.readInt()) {
                case 1:
                    filmsFactory.createFilm();
                    break;
                case 2:
                    consoleHelper.writeMessage("Films : ");

                    continue;
                case 3:
                    continue;
                case 0:
                    return;
                default:
                    consoleHelper.writeMessage("Wrong number of option, try again");
            }

        }


    }
}