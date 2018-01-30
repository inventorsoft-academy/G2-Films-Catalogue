package filmCatalog.dataBase;


import filmCatalog.film.Film;
import filmCatalog.user.User;
import filmCatalog.userReview.UserReview;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Komatoz on 18.01.2018.
 */
public final class DataBase {
    private DataBase() {
    }


    private static List<User> users;
    private static List<Film> films = new LinkedList<>();
    private static List<UserReview> userReviews;


    private final static String DATA_BASE_PATH_USERS = "dataBase/Users";
    private final static String DATA_BASE_PATH_FILMS = "dataBase/Films";
    private final static String DATA_BASE_PATH_USER_REVIEW = "dataBase/UserReview";

    static List<UserReview> getUserReviews() {
        return userReviews;
    }

    static List<User> getUsers() {
        return users;
    }


    //TODO think about it
    static List<Film> getFilms() {
        return films;
    }




    public static void loadAllDataFromFile(){
        loadAllUsersFromFile();
        loadAllUserReviewFromFile();
   //TODO     loadAllFilmsFromFile();
    }

    public static void saveAllDataToFile() {
        saveAllFilmsToFile();
        saveAllUserReviewToFile();
        saveAllUsersToFile();
    }

    private static void saveAllUsersToFile(){

        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_USERS)) {


            for (User user : UserDataBase.getUsers()) {
                fw.write(user.saveUser());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }


    }

    private static void saveAllUserReviewToFile() {
        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_USER_REVIEW)) {


            for (UserReview userReview : UserReviewDataBase.getUserReviews()) {
                fw.write(userReview.saveUserReview());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
    }

    private static void saveAllFilmsToFile() {
        try (FileWriter fw = new FileWriter(DATA_BASE_PATH_FILMS)) {


            for (Film film : films) {
                fw.write(film.saveFilm());
            }
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();
        }
    }

    private static void loadAllUsersFromFile() {


        try {
            users = Files.lines(Paths.get(DATA_BASE_PATH_USERS)).map(User::loadUser).collect(Collectors.toList());
        } catch (IOException e) {
            //TODO
            e.printStackTrace();

        }


    }

    private static void loadAllUserReviewFromFile() {
        try {
            userReviews = Files.lines(Paths.get(DATA_BASE_PATH_USER_REVIEW)).map(UserReview::loadUserReview).collect(Collectors.toList());
        } catch (IOException e) {
            //TODO
            e.printStackTrace();

        }


    }

    private static void loadAllFilmsFromFile(){
        try {
            films = Files.lines(Paths.get(DATA_BASE_PATH_FILMS)).map(Film::loadFilmFromString).collect(Collectors.toList());
        } catch (IOException e) {
            //TODO log
            e.printStackTrace();

        }
    }

}
