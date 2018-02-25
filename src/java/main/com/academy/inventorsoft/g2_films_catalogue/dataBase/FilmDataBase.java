package academy.inventorsoft.g2_films_catalogue.dataBase;


import academy.inventorsoft.g2_films_catalogue.model.Film;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by Komatoz on 15.01.2018.
 */
@Component
public class FilmDataBase {


    private DataBase dataBase;

    private FilmDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
        this.films = dataBase.getFilms();

    }


    private List<Film> films;


    public List<Film> getFilms() {
        List<Film> temp = films;
        Collections.reverse(temp);

        return temp;
    }


    public boolean hasFilm(String filmName) {
        return films.stream().anyMatch(f -> f.getName().equalsIgnoreCase(filmName));
    }

    public void addFilmToDataBase(Film film) {
        films.add(film);
    }


    public List<Film> top10Films() {
        return films.stream().sorted(comparatorLikeDisLike).limit(10).collect(Collectors.toList());
    }

    public Optional<Film> getFilmByName(String filmName) {
        return films.stream().filter(res -> res.getName().equalsIgnoreCase(filmName)).findFirst();


    }

    private Comparator<Film> comparatorLikeDisLike = (o1, o2) -> o2.getDifferenceBetweenCountLikeAndDislike() - o1.getDifferenceBetweenCountLikeAndDislike();

    public List<String> getTop10Director() {
        List<String> directorList = films.stream().map(Film::getDirector).distinct().collect(Collectors.toList());

        return directorList.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getAllDirectorsLike(o2) - getAllDirectorsLike(o1);
            }
        }).limit(10).collect(Collectors.toList());

    }


    private int getAllDirectorsLike(String directorName) {
        return films.stream().filter(film -> film.getDirector().equalsIgnoreCase(directorName)).map(Film::getDifferenceBetweenCountLikeAndDislike).reduce(Integer::sum).get();
    }


    public void saveData() {
        dataBase.saveAllFilmsToFile(films);
    }
}
