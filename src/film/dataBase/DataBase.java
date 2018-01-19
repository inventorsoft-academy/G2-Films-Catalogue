package film.dataBase;

import film.User;

import java.io.*;


/**
 * Created by Komatoz on 18.01.2018.
 */
public abstract class DataBase {
    public static File getDataBasePathUsers() {
        return DATA_BASE_PATH_USERS;
    }

    private final static File DATA_BASE_PATH_USERS = new File("dataBase/users");
    private final static File DATA_BASE_PATH_FILMS = new File("dataBase/films/");


    public static String[] getAllUserNames() {
        return DATA_BASE_PATH_USERS.list();
    }


    public static User loadUser(String userName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(DATA_BASE_PATH_USERS + "/" + userName));
        User user = new User(reader.readLine(), reader.readLine(), reader.readLine(), Boolean.valueOf(reader.readLine()));
        reader.close();

        return user;
    }

    public static <T extends SaveLoad> void save(T type) {
        try {
            type.saveData(DATA_BASE_PATH_USERS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**  public static  void saveUser(User user) throws IOException {

     File file =  new File(DATA_BASE_PATH_USERS+"/"+user.getLogin_email());
     file.createNewFile();
     fw = new FileWriter(file);
     fw.write(user.getNickName() + "\n");
     fw.write(user.getLogin_email() + "\n");
     fw.write(user.getPassword() + "\n");
     fw.write(String.valueOf(user.isAdministrator()) + "\n");

     System.out.println("Save: " + user.getLogin_email());
     fw.close();

     **/


}
