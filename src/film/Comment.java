package film;

import java.time.LocalDate;


/**
 * Created by Komatoz on 15.01.2018.
 */
public class Comment {
    private final String text;
    private int like=0;
    private int dislike=0;
    private String userName;
    private LocalDate localDate;

    public Comment(String text, String userName) {
       localDate = LocalDate.now();
        this.text = text;
        this.userName = userName;
    }

    public void likeComment(){
        like++;
    }


    public void dilikeComment(){
        dislike++;
    }

}
