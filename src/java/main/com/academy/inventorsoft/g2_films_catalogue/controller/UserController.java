package academy.inventorsoft.g2_films_catalogue.controller;


import academy.inventorsoft.g2_films_catalogue.dataBase.UserDataBase;
import academy.inventorsoft.g2_films_catalogue.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE, OPTIONS})
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDataBase userDataBase;


    @GetMapping(value = "/isModerator", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity isUserModerator(@RequestParam(value = "login") String login) {
        System.out.println("isModerator: " + login);
        System.out.println(userDataBase.isModerator(login));
        if (userDataBase.isModerator(login)) {
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/isUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity isUserInBase(@RequestParam(value = "login") String login,
                                  @RequestParam(value = "password") String password) {
        System.out.println("hesUser: " + login);
        System.out.println(userDataBase.isUser(login, password));
        if (userDataBase.isUser(login, password)) {
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam(value = "login") String login) {
        System.out.println("getUser: " + login);
        return userDataBase.getUser(login).get();
    }

    @PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println("addUser");

        if (!userDataBase.hasUserInBase(user.getLoginEmail())) {
            userDataBase.addUser(user);
            userDataBase.saveData();//TODO забрати це !!!
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }






}
