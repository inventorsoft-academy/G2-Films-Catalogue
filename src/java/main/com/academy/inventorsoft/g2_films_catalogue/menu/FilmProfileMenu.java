package academy.inventorsoft.g2_films_catalogue.menu;

import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.dataBase.UserReviewDataBase;
import academy.inventorsoft.g2_films_catalogue.film.Film;
import academy.inventorsoft.g2_films_catalogue.userReview.UserReview;
import academy.inventorsoft.g2_films_catalogue.utilitClass.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmProfileMenu {
    @Autowired
    private ConsoleHelper consoleHelper;
    @Autowired
    private FilmDataBase filmDataBase;
    @Autowired
    private UserReviewDataBase userReviewDataBase;

    private FilmProfileMenu() {
    }

    public  void execute() {
        Film film;
        List<UserReview> userReviews;


        while (true) {
            consoleHelper.writeMessage("Please enter name of film: ");
            String filmName = consoleHelper.readString();
            if (filmDataBase.hasFilm(filmName)) {

            }else{
                consoleHelper.writeMessage("We don't have this film");
                return;}





        }
    }



}
