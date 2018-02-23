package academy.inventorsoft.g2_films_catalogue.film;




import academy.inventorsoft.g2_films_catalogue.enums.Genres;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.*;

import static java.util.stream.Collectors.joining;


/**
 * Created by Komatoz on 13.01.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {


    private String name;
    private String director;
    private String adminReview;
    private TreeSet<Genres> genres;
    private List<String> likeList = new LinkedList<>();
    private List<String> disLikeList = new LinkedList<>();

    @JsonCreator
    public Film(@JsonProperty("name") String name,
                @JsonProperty("director") String director,
                @JsonProperty("genres")TreeSet<Genres> genres,
                @JsonProperty("adminReview")String adminReview) {
        this.adminReview = adminReview;
        this.name = name;
        this.director = director;
        this.genres = genres;
    }



    public void likeFilm(String userLogin)
    {
        if(!likeList.contains(userLogin) && !disLikeList.contains(userLogin)){
            likeList.add(userLogin);
        } else if(!likeList.contains(userLogin) && disLikeList.contains(userLogin)){
            disLikeList.remove(userLogin);
            likeList.add(userLogin);
        }
    }



    public void dislikeFilm(String userLogin) {
        if(!disLikeList.contains(userLogin) && !likeList.contains(userLogin)){
            disLikeList.add(userLogin);
        } else if (!disLikeList.contains(userLogin) && likeList.contains(userLogin)){
            likeList.remove(userLogin);
            disLikeList.add(userLogin);
        }
    }

    private static TreeSet<Genres> loadGenresFromString(String file){
        String genre = file.substring(file.indexOf("<genreTag%>")+12, file.lastIndexOf("<genreTag%>")-1);
        String[] genres = genre.split(",");
        TreeSet<Genres> genresTreeSet = new TreeSet<>();
        for (String s : genres) {
            genresTreeSet.add(Genres.valueOf(s.trim()));
        }

        return genresTreeSet;
    }

    public static Film loadFilmFromString(String file){
        String[] s = file.split("<FilmTag%>");
        String name = s[0];
        String director = s[1];
        String review = s[2];
        TreeSet<Genres> genres = loadGenresFromString(file);
        Film film = new  Film(name, director, genres, review);
        if (!s[3].isEmpty()) {
            film.setLikeList(new LinkedList<>(Arrays.asList(s[3].split(","))));
        }
        if (!s[4].isEmpty()) {
            film.setDisLikeList(new LinkedList<>(Arrays.asList(s[4].split(","))));
        }

        return film;
    }


    public int getDifferenceBetweenCountLikeAndDislike(){
        return this.likeList.size()-this.disLikeList.size();
    }

    public String saveFilm(){
        String result =
                this.name+ "<FilmTag%>"
                        + this.director + "<FilmTag%>"
                        + this.adminReview+ "<FilmTag%>"
                        + this.likeList.stream().collect(joining(",")) + "<FilmTag%>"
                        + this.disLikeList.stream().collect(joining(",")) + "<FilmTag%>"
                        + "<genreTag%>" + this.genres.toString() +  "<genreTag%>\n";
        return result;
    }





    @Override
    public String toString() {
        return "Film{" + "name='" + name + '\'' + ", director='" + director + '\'' + ", adminReview='" + adminReview + '\'' + ", genres=" + genres + '}';
    }
}
