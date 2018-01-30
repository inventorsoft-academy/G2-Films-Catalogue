package filmCatalog.utilitClass;


import java.util.Scanner;

/**
 * Created by Komatoz on 13.01.2018.
 */
public class ConsoleHelper {
    private ConsoleHelper() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {

        String text = scanner.nextLine();

        while (!Validator.validationEmptyFild(text)) {
            text = scanner.nextLine();
        }

        return text;

    }


    public static int readInt() {

        String s = scanner.nextLine();
        while (!Validator.isNumber(s)) {
            s = scanner.nextLine();
        }

        int x = Integer.parseInt(s);


        return x;
    }


}
