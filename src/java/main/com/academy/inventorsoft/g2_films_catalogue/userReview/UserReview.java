package academy.inventorsoft.g2_films_catalogue.userReview;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * Created by Komatoz on 15.01.2018.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserReview{

    private  String id;
    private  String text;
    private  String filmID;
    private  String userLogin;
    private  String userName;
    private  LocalDateTime createTime;
    private  List<String> likeList = new LinkedList<>();
    private  List<String> disLikeList = new LinkedList<>();
    @JsonCreator
    public UserReview(@JsonProperty("text") String text,@JsonProperty("userName") String userName,@JsonProperty("filmId") String filmID,@JsonProperty("userLogin") String userLogin) {
        LocalDateTime lt = LocalDateTime.now();
        this.createTime = lt;
        this.text = text;
        this.userName = userName;
        this.filmID = filmID;
        this.userLogin = userLogin;
        this.id = userLogin +":" + lt;
    }

    public void likeComment(String userLogin)
    {
        if(!likeList.contains(userLogin) && !disLikeList.contains(userLogin)){
            likeList.add(userLogin);
            } else if(!likeList.contains(userLogin) && disLikeList.contains(userLogin)){
            disLikeList.remove(userLogin);
            likeList.add(userLogin);
        }
    }



    public void dislikeComment(String userLogin) {
        if(!disLikeList.contains(userLogin) && !likeList.contains(userLogin)){
            disLikeList.add(userLogin);
        } else if (!disLikeList.contains(userLogin) && likeList.contains(userLogin)){
            likeList.remove(userLogin);
            disLikeList.add(userLogin);
        }
    }



    public String saveUserReview(){
        String result =
                  this.text + "<UserRTag%>"
                + this.userName + "<UserRTag%>"
                + this.filmID + "<UserRTag%>"
                + this.userLogin + "<UserRTag%>"
                + this.createTime +"<UserRTag%>"
                + this.likeList.stream().collect(joining(",")) + "<UserRTag%>"
                + this.disLikeList.stream().collect(joining(",")) + "<UserRTag%>"
                + this.id +"<UserRTag%>" + "\n";
        return result;
    }


    public int getSumLikeAndDislike(){
        return this.likeList.size()+this.disLikeList.size();
    }

    public static UserReview loadUserReview(String userReview) {
        
        String[] s = userReview.split("<UserRTag%>");
        String text = s[0];
        String name = s[1];
        String filmID = s[2];
        String userEmail = s[3];
        UserReview ur = new UserReview(text, name, filmID, userEmail);
        ur.createTime = LocalDateTime.parse(s[4]);
        if (!s[5].isEmpty()) {
            ur.setLikeList(new LinkedList<>(Arrays.asList(s[5].split(","))));
        }
        if (!s[6].isEmpty()) {
            ur.setDisLikeList(new LinkedList<>(Arrays.asList(s[6].split(","))));
        }
        ur.id = s[7];
        return ur;

    }



}
