package filmCatalog.film;


import filmCatalog.enumations.Genres;
import filmCatalog.userReview.UserReview;

import java.util.*;


/**
 * Created by Komatoz on 13.01.2018.
 */
public class Film {


    private final String name;
    private final String director;
    private final String adminReview;
    private final TreeSet<Genres> genres;
    private LinkedList<UserReview> userReviews;


    public Film(String name, String director, TreeSet<Genres> genres, String adminReview) {
        this.adminReview = adminReview;
        this.name = name;
        this.director = director;
        this.genres = genres;
    }
    public String getName() {
        return name;
    }

    public TreeSet<Genres> getGenres() {
        return genres;
    }

    public String saveFilm(){
        String result = name+ "<filmTag%>" + director + "<filmTag%>" + adminReview+ "<genreTag%>" + genres.toString() +  "<genreTag%>\n";
    return result;
    }
    //TODO as this method works
    private void loadUserReviewFromUserReviewDataBaseToThisFilm(LinkedList<UserReview> userR){
        Optional.ofNullable(userR).map(userReviews::addAll)
                .orElse(false);
    }

    private static TreeSet<Genres> loadGenresFromString(String file){
        String genre = file.substring(file.indexOf("<genreTag%>")+12, file.lastIndexOf("<genreTag%>")-1);
        String[] genres = genre.split(",");
        TreeSet<Genres> genresTreeSet = new TreeSet<>();
        for (String s : genres) {
            genresTreeSet.add(Genres.valueOf(s));
        }

        return genresTreeSet;
    }
    //TODO
    public static Film loadFilmFromString(String file){
        return null;
    }


    @Override
    public String toString() {
        return "Film{" + "name='" + name + '\'' + ", director='" + director + '\'' + ", adminReview='" + adminReview + '\'' + ", genres=" + genres + ", userReviews=" + userReviews + '}';
    }







}
