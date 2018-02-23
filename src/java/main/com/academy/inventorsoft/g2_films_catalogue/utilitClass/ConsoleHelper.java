package academy.inventorsoft.g2_films_catalogue.utilitClass;


import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by Komatoz on 13.01.2018.
 */
@Component
public class ConsoleHelper {
    private ConsoleHelper() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void writeMessage(String message) {

        System.out.println(message);
    }

    public  String readString() {

        String text = scanner.nextLine();
        while (Validator.validationEmptyField(text)) {
            System.out.println("Your text is empty, try again");
            text = scanner.nextLine();
        }

        return text;

    }


    public  int readInt() {

        String s = scanner.nextLine();
        while (!Validator.isNumber(s)) {
            System.out.println("No Bro. Only number :) \n One more time please");
            s = scanner.nextLine();
        }

        int x = Integer.parseInt(s);


        return x;
    }


}
