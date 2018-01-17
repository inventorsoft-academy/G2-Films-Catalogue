package film;

import film.Comment;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Komatoz on 13.01.2018.
 */
public class Film {

    private final LocalDate time;
    private final String name;
    private final ArrayList<String> ganres;
    private final String director;
    private final String review;
    private Queue<Comment> comments;


    public Film(String name, String director, ArrayList<String> ganre, String review) {
        this.time = LocalDate.now();
        this.review = review;
        this.name = name;
        this.director = director;
        this.ganres = ganre;
    }
}
