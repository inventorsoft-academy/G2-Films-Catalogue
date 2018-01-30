package filmCatalog.userReview;

import java.time.LocalDateTime;
/**
 * Created by Komatoz on 15.01.2018.
 */
public class UserReview{
    private  String text;
    private  String filmID;
    private String userName;
    private int like = 0;
    private int dislike = 0;
    private LocalDateTime createTime;

    public UserReview(String text, String userName, String filmID) {
        this.createTime = LocalDateTime.now();
        this.text = text;
        this.userName = userName;
        this.filmID =filmID;
    }

    public void likeComment() {
        this.like++;
    }


    public void dislikeComment() {
        this.dislike++;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public String getFilmID() {
        return filmID;
    }

    public String saveUserReview(){
        String result = this.text + "<UserRTag%>"
                + this.userName + "<UserRTag%>"
                + this.filmID + "<UserRTag%>"
                + this.like + "<UserRTag%>"
                + this.dislike + "<UserRTag%>"
                + this.createTime +"<UserRTag%>\n";
        return result;
    }


    public static UserReview loadUserReview(String userReview) {
        String[] s = userReview.split("<UserRTag%>");
        String text = s[0];
        String name = s[1];
        String filmID = s[2];
        UserReview ur = new UserReview(text, name, filmID);
        ur.like = Integer.parseInt(s[3]);
        ur.dislike = Integer.parseInt(s[4]);
        ur.createTime = LocalDateTime.parse(s[5]);
        return ur;

    }


    @Override
    public String toString() {
        return "UserReview{" + "text='" + text + '\'' + ", filmID='" + filmID + '\'' + ", userName='" + userName + '\'' + ", like=" + like + ", dislike=" + dislike + ", createTime=" + createTime + '}';
    }
}
