package filmCatalog.userReview;

import filmCatalog.dataBase.UserReviewDataBase;
import filmCatalog.utilitClass.ConsoleHelper;


/**
 * Created by Komatoz on 29.01.2018.
 */
public class UserReviewFactory {
    private UserReviewFactory(){}

    public static void createUserReview(String filmName,String userName){
        ConsoleHelper.writeMessage("Please write your review");
        String text = ConsoleHelper.readString();

        //TODO Save to DataBase
        UserReviewDataBase.addUserReviewToBase(new UserReview(text, userName, filmName));

    }



}
