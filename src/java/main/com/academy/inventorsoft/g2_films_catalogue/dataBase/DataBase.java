package academy.inventorsoft.g2_films_catalogue.dataBase;


import academy.inventorsoft.g2_films_catalogue.model.Film;
import academy.inventorsoft.g2_films_catalogue.model.User;
import academy.inventorsoft.g2_films_catalogue.model.UserReview;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Komatoz on 18.01.2018.
 */

@Component
public final class DataBase {
    private List<User> users = loadAllUsersFromFile();
    private List<Film> films = loadAllFilmsFromFile();
    private List<UserReview> userReviews = loadAllUserReviewFromFile();


    private final String DATA_BASE_PATH_USERS = "dataBase/Users";
    private final String DATA_BASE_PATH_FILMS = "dataBase/Films";
    private final String DATA_BASE_PATH_USER_REVIEW = "dataBase/UserReview";


    List<UserReview> getUserReviews() {
        return userReviews;
    }

    List<User> getUsers() {
        return users;
    }


    //TODO think about it
    List<Film> getFilms() {
        return films;
    }









     void saveAllUsersToFile(List<User> users){

        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_USERS)) {


           for (User user : users) {
                fw.write(user.convertUserToString());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }


    }

    void saveAllUserReviewToFile(List<UserReview> userReviews) {
        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_USER_REVIEW)) {


            for (UserReview userReview : userReviews) {
                fw.write(userReview.saveUserReview());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
    }

     void saveAllFilmsToFile(List<Film> films) {
        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_FILMS)) {


            for (Film film : films) {
                fw.write(film.saveFilm());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
    }

    private List<User> loadAllUsersFromFile() {
        List<User> result = new LinkedList<>();


        try {
            result = Files.lines(Paths.get(DATA_BASE_PATH_USERS)).map(User::loadUser).collect(Collectors.toList());
        } catch (IOException e) {

        }
        return result;

    }

    private List<UserReview> loadAllUserReviewFromFile() {
        List<UserReview> userReviewList = new LinkedList<>();

        try {
            userReviewList = Files.lines(Paths.get(DATA_BASE_PATH_USER_REVIEW)).map(UserReview::loadUserReview).collect(Collectors.toList());
        } catch (IOException e) {
            //TODO
            e.printStackTrace();

        }

        return userReviewList;
    }

    private List<Film> loadAllFilmsFromFile() {
        List<Film> filmList = new LinkedList<>();
        try {
            filmList = Files.lines(Paths.get(DATA_BASE_PATH_FILMS)).map(Film::loadFilmFromString).collect(Collectors.toList());
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();

        }
        return filmList;
    }

}
