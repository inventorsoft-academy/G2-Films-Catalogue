package film;

;import film.Film;

import java.util.ArrayList;

/**
 * Created by Komatoz on 15.01.2018.
 */
public class FilmLibrary {
    public ArrayList<Film> films = new ArrayList<>();


    void addFilm(Film film){
        films.add(film);
    }

}
