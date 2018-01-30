package filmCatalog.film;

import filmCatalog.dataBase.FilmDataBase;
import filmCatalog.enumations.Genres;
import filmCatalog.utilitClass.ConsoleHelper;
import filmCatalog.utilitClass.Validator;

import java.util.TreeSet;


/**
 * Created by Komatoz on 28.01.2018.
 */
public class FilmsFactory {

    private FilmsFactory() {
    }


    public static void createFilm() {

        ConsoleHelper.writeMessage("Enter the unique filename for uploading new film (Film Name) ");
        String filmName = ConsoleHelper.readString();
        while(FilmDataBase.hasFilm(filmName)){
            ConsoleHelper.writeMessage("We already have such movie");
            filmName =ConsoleHelper.readString();
        }

        ConsoleHelper.writeMessage("Who is director of film?");
        String directorName = ConsoleHelper.readString();


        ConsoleHelper.writeMessage("Please approve film review. It is at least 20 characters");
        String review = ConsoleHelper.readString();
        while (review.length() < 20) {
            ConsoleHelper.writeMessage("Sorry but your text is very short, try again");
            review = ConsoleHelper.readString();
        }


        ConsoleHelper.writeMessage("Please select a genre:\n");
        for (int i = 0; i < Genres.values().length; i++) {
            ConsoleHelper.writeMessage(Genres.values()[i] + " : push[" + (i + 1) + "]");
        }

        ConsoleHelper.writeMessage("Exit - push [0]\n");


        TreeSet<Genres> genres = new TreeSet<>();
        int count = 0;
        while (count<3) {
            ConsoleHelper.writeMessage("Please select a genre (min 1 and max 3):");

            int x = ConsoleHelper.readInt();
            switch (x) {
                case 1:
                    genres.add(Genres.ACTION);
                    count++;
                    continue;
                case 2:
                    genres.add(Genres.ADVENTURE);
                    count++;
                    continue;
                case 3:
                    genres.add(Genres.COMEDY);
                    count++;
                    continue;
                case 4:
                    genres.add(Genres.CRIME_AND_GANGSTER);
                    count++;
                    continue;
                case 5:
                    genres.add(Genres.DRAMA);
                    count++;
                    continue;
                case 6:
                    genres.add(Genres.HISTORICAL);
                    count++;
                    continue;
                case 7:
                    genres.add(Genres.HORROR);
                    count++;
                    continue;
                case 8:
                    genres.add(Genres.MUSICAL);
                    count++;
                    continue;
                case 9:
                    genres.add(Genres.SCIENCE_FICTION);
                    count++;
                    continue;
                case 10:
                    genres.add(Genres.WAR);
                    count++;
                    continue;
                case 11:
                    genres.add(Genres.WESTERNS);
                    count++;
                    continue;
                case 0:

                    if (count == 0) {
                        continue;
                    }else count+=3;
                    continue;


                default:
                    ConsoleHelper.writeMessage("Wrong number of option, try again");


            }

        }
        ConsoleHelper.writeMessage("You upload new film: " + filmName);
        FilmDataBase.addFilmToDataBase( new Film(filmName, directorName, genres, review));

    }


}
