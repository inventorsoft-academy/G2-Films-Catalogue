package filmCatalog.dataBase;
import filmCatalog.film.Film;
import filmCatalog.utilitClass.ConsoleHelper;
import java.util.List;


/**
 * Created by Komatoz on 15.01.2018.
 */
public class FilmDataBase {
    private FilmDataBase(){}


    private static List<Film> films = DataBase.getFilms();


    static List<Film> getFilms() {
        return films;
    }



    public static boolean hasFilm(String filmName){
        return films.stream().filter(f -> f.getName().equalsIgnoreCase(filmName)).findFirst().isPresent();
    }

    public static void addFilmToDataBase(Film film){
        films.add(film);
    }


    public static void viewAllFilms(){
        if (films.isEmpty()) ConsoleHelper.writeMessage("we don't have films :(\n");
        else films.stream().forEach(p->ConsoleHelper.writeMessage(p.getName()));
    }

    public static void exportTop10ToFile(){
        //TODO
    }

    public static void top10Films(){
        //TODO
    }


}
