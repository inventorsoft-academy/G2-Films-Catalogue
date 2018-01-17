package film;



import java.io.IOException;

/**
 * Created by Komatoz on 17.01.2018.
 */
public class Registration {
        public static void execute() {

            boolean done = true;
            ConsoleHelper.writeMessage("Welcome to registration new User\n");
            while (done) {
                String login = "";
                String password = "";
                String nickName = "";

                boolean isAdmin = false;

                try {

                    ConsoleHelper.writeMessage("Please enter your Login - email");
                    login = ConsoleHelper.readString();

                    if (!ConsoleHelper.isValidEmail(login)) {
                        ConsoleHelper.writeMessage("Email is not correct");
                        continue;
                    }



                    if (Authorization.isUser(login)){
                        ConsoleHelper.writeMessage("Sorry, but this login is busy");
                        continue;
                    }

                    ConsoleHelper.writeMessage("Please enter your password");
                    password = ConsoleHelper.readString();

                    ConsoleHelper.writeMessage("Please enter your nickname");
                    nickName = ConsoleHelper.readString();


                    ConsoleHelper.writeMessage("If you Administrator, please, write word root");
                    if (ConsoleHelper.readString().equalsIgnoreCase("root")) isAdmin =true;


                } catch (IOException e) {
                    e.printStackTrace();
                }

                User user = new User(nickName, login, password, isAdmin);
                done = false;
                ConsoleHelper.writeMessage("Registration account done");

                ConsoleHelper.writeMessage(user.toString());

            }

        }
}
