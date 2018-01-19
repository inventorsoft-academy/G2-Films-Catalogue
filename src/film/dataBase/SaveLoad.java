package film.dataBase;

import java.io.File;
import java.io.IOException;

/**
 * Created by Komatoz on 19.01.2018.
 */
public interface SaveLoad {
     void saveData(File file) throws IOException;
     void loadData();
}
