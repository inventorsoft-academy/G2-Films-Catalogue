package film;


import film.dataBase.DataBase;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Komatoz on 13.01.2018.
 */
public class Film {
    private final String name;
    private final LocalDate time;
    private final String director;
    private final String adminReview;
    private final String[] genres;
    private Queue<UserReview> userReviews;


    public Film(String name, String director, String[] ganres, String adminReview) {
        this.time = LocalDate.now();
        this.adminReview = adminReview;
        this.name = name;
        this.director = director;
        this.genres = ganres;
    }


}
