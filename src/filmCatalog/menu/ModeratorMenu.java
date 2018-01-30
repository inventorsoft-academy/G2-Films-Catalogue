package filmCatalog.menu;

import filmCatalog.dataBase.FilmDataBase;
import filmCatalog.film.FilmsFactory;
import filmCatalog.utilitClass.ConsoleHelper;


import static filmCatalog.utilitClass.ConsoleHelper.readInt;
import static filmCatalog.utilitClass.ConsoleHelper.writeMessage;

/**
 * Created by Komatoz on 28.01.2018.
 */
public class ModeratorMenu {
    public static void execute() {
        writeMessage("Welcome to moderator menu\n");


        while (true) {
            writeMessage(" Add new Film               - push [1] \n" + " View all films             - push [2]\n" + " Export top 10 films rating - push [3]\n" + " Exit                       - push [0]\n");
            writeMessage(" Please enter your choice:");
            switch (readInt()) {
                case 1:
                    FilmsFactory.createFilm();
                    break;
                case 2:
                    ConsoleHelper.writeMessage("Films : ");
                    FilmDataBase.viewAllFilms();
                    continue;
                case 3:
                    continue;
                case 0:
                    return;
                default:
                    writeMessage("Wrong number of option, try again");
            }

        }


    }
}