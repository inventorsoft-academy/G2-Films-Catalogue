package academy.inventorsoft.g2_films_catalogue.film;


import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.enums.Genres;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.TreeSet;


/**
 * Created by Komatoz on 28.01.2018.
 */
@Component
public class FilmsFactory {
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    FilmDataBase filmDataBase;

    public void saveFilm(Film film){

    }



    public  void createFilm() {

        consoleHelper.writeMessage("Enter the unique filename for uploading new film (Film Name) ");
        String filmName = consoleHelper.readString();
        while(filmDataBase.hasFilm(filmName)){
            consoleHelper.writeMessage("We already have such movie");
            filmName =consoleHelper.readString();
        }

        consoleHelper.writeMessage("Who is director of film?");
        String directorName = consoleHelper.readString();


        consoleHelper.writeMessage("Please approve film review. It is at least 20 characters");
        String review = consoleHelper.readString();
        while (review.length() < 20) {
            consoleHelper.writeMessage("Sorry but your text is very short, try again");
            review = consoleHelper.readString();
        }


        consoleHelper.writeMessage("Please select a genre:\n");
        for (int i = 0; i < Genres.values().length; i++) {
            consoleHelper.writeMessage(Genres.values()[i] + " : push[" + (i + 1) + "]");
        }

       consoleHelper.writeMessage("Exit - push [0]\n");


        TreeSet<Genres> genres = new TreeSet<>();
        int count = 0;
        while (count<3) {
            consoleHelper.writeMessage("Please select a genre (min 1 and max 3):");

            int x = consoleHelper.readInt();
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
                    consoleHelper.writeMessage("Wrong number of option, try again");


            }

        }
        consoleHelper.writeMessage("You upload new film: " + filmName);
        filmDataBase.addFilmToDataBase( new Film(filmName, directorName, genres, review));

    }


}
