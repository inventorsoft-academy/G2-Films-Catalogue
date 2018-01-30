package filmCatalog;



import filmCatalog.menu.AuthorizationMenu;
import filmCatalog.dataBase.DataBase;

import java.io.IOException;



/**
 * Created by Komatoz on 13.01.2018.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        DataBase.loadAllDataFromFile();


        AuthorizationMenu.execute();



        DataBase.saveAllDataToFile();
    }


}