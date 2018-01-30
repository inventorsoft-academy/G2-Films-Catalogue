package filmCatalog.dataBase;

import filmCatalog.userReview.UserReview;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Komatoz on 30.01.2018.
 */
public class UserReviewDataBase {
    private UserReviewDataBase(){}

    private static List<UserReview> userReviews = DataBase.getUserReviews();

    static List<UserReview> getUserReviews() {
        return userReviews;
    }

    public static void addUserReviewToBase(UserReview userReview){
        userReviews.add(userReview);
    }


    public static List<UserReview> getUserReviewToFilm(String filmName){
        return userReviews.stream().filter(ur->ur.getFilmID().equalsIgnoreCase(filmName)).collect(Collectors.toList());
    }


}
