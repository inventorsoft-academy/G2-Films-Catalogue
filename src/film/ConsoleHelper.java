package film;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Komatoz on 13.01.2018.
 */
public abstract class ConsoleHelper {

        private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        public static void writeMessage(String message) {
            System.out.println(message);
        }

        public static String readString() throws IOException {
            String text = bis.readLine();
            return text;
        }

        public static int readInt() throws IOException {
            String text = readString();
            return Integer.parseInt(text.trim());
        }

        public static boolean isValidEmail(String email){


            return email.contains("@");
        }





}
