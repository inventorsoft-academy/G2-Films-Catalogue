package academy.inventorsoft.g2_films_catalogue.dataBase;




import academy.inventorsoft.g2_films_catalogue.userReview.UserReview;
import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Komatoz on 30.01.2018.
 */
@Getter
@Component
public class UserReviewDataBase implements SaveDataToFile {
    private List<UserReview> userReviews;
    private DataBase dataBase;
    private UserReviewDataBase(DataBase dataBase){
        this.dataBase = dataBase;
        this.userReviews = dataBase.getUserReviews();
    }







    public  void addUserReviewToBase(UserReview userReview){
        userReviews.add(userReview);
    }


    Comparator <UserReview> comparatorByTimeOfCreate = new Comparator<UserReview>() {
        @Override
        public int compare(UserReview o1, UserReview o2) {
            return o2.getCreateTime().compareTo(o1.getCreateTime());
        }
    };

    public List<UserReview> getUserReviewToFilm(String filmName){
        return userReviews.stream().filter(ur->ur.getFilmID().equalsIgnoreCase(filmName)).sorted(comparatorByTimeOfCreate).collect(Collectors.toList());
    }

    public  List<UserReview> getUserReviewToUser(String userLogin){
        return userReviews.stream().filter(ur->ur.getUserLogin().equalsIgnoreCase(userLogin)).sorted(comparatorByTimeOfCreate).collect(Collectors.toList());
    }

    public Optional<UserReview> findReviewById(String id){
         return userReviews.stream().filter(res -> res.getId().equalsIgnoreCase(id)).findFirst();
    }


    @Override
    public void saveData() {
        dataBase.saveAllUserReviewToFile(userReviews);
    }

    public List<UserReview> getTop10UserReview() {
         return userReviews.stream().sorted(new Comparator<UserReview>() {
            @Override
            public int compare(UserReview o1, UserReview o2) {
                return o2.getSumLikeAndDislike()-o1.getSumLikeAndDislike();
            }
        }).limit(10).collect(Collectors.toList());
    }
}
