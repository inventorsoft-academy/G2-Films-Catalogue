package academy.inventorsoft.g2_films_catalogue.controller;


import academy.inventorsoft.g2_films_catalogue.dataBase.UserReviewDataBase;
import academy.inventorsoft.g2_films_catalogue.userReview.UserReview;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE, OPTIONS})
@RequestMapping(value = "/review")
public class ReviewController {
    UserReviewDataBase userReviewDataBase;

    public ReviewController(UserReviewDataBase userReviewDataBase) {
        this.userReviewDataBase = userReviewDataBase;
    }


    @GetMapping(value = "/getReviewListByFilmId")
    public List<UserReview> getReviewListByFilm(@RequestParam(value = "filmId") String filmId) {
        System.out.println("getRev");
        return userReviewDataBase.getUserReviewToFilm(filmId);
    }

    @GetMapping(value = "/getTop10Review")
    public List<UserReview> getTop10Review() {
        System.out.println("getTop10Review");
        return userReviewDataBase.getTop10UserReview();
    }

    @GetMapping(value = "/getReviewListByUserLogin")
    public List<UserReview> getReviewListByUser(@RequestParam(value = "userLogin") String userLogin) {
        System.out.println("getRev");
        return userReviewDataBase.getUserReviewToUser(userLogin);
    }

    @PostMapping(value = "/addReview")
    public UserReview addReview(@RequestBody UserReview userReview) {
        userReviewDataBase.addUserReviewToBase(userReview);
        System.out.println("add rev:" + userReview.toString());
        userReviewDataBase.saveData();
      return userReviewDataBase.findReviewById(userReview.getId()).get();
    }


    @GetMapping(value = "/setLike", produces = MediaType.APPLICATION_JSON_VALUE)
    public void likeReview(@RequestParam(value = "userLogin") String userLogin,
                           @RequestParam(value = "id") String id) {
        System.out.println("setLike: " + userLogin + id);

        userReviewDataBase.findReviewById(id).get().likeComment(userLogin);
        userReviewDataBase.saveData();

    }

    @GetMapping(value = "/setDisLike", produces = MediaType.APPLICATION_JSON_VALUE)
    public void dislikeReview(@RequestParam(value = "userLogin") String userLogin,
                              @RequestParam(value = "id") String id) {
        System.out.println("dislike: " + userLogin + id);
        userReviewDataBase.findReviewById(id).get().dislikeComment(userLogin);
        userReviewDataBase.saveData();
    }


}
