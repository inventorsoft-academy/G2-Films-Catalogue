package film;


import film.dataBase.DataBase;
import film.dataBase.SaveLoad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Komatoz on 15.01.2018.
 */
public class User implements SaveLoad{
    private final String nickName;
    private final String login_email;
    private final String password;
    private final boolean isAdministrator;

    public User(String nickName, String login_email, String password, boolean isAdministrator) {
        this.nickName = nickName;
        this.login_email = login_email;
        this.password = password;
        this.isAdministrator = isAdministrator;
    }


    public String getNickName() {
        return nickName;
    }

    public String getLogin_email() {
        return login_email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    @Override
    public String toString() {
        return "User{" + "nickname='" + nickName + '\'' + ", login_email='" + login_email + '\'' + ", password='" + password + '\'' + ", isAdministrator=" + isAdministrator + '}';
    }


    public static  void saveUser(User user) throws IOException {

        File file =  new File(DataBase.getDataBasePathUsers()+"/"+user.getLogin_email());
        file.createNewFile();




    }


    @Override
    public void saveData(File file) throws IOException {
        file.createNewFile();
        FileWriter fw = new FileWriter(file+"/"+this.getLogin_email());
        fw.write(this.getNickName() + "\n");
        fw.write(this.getLogin_email() + "\n");
        fw.write(this.getPassword() + "\n");
        fw.write(String.valueOf(this.isAdministrator()) + "\n");

        System.out.println("Save: " + this.getLogin_email());
        fw.close();
    }

    @Override
    public void loadData() {

    }
}
