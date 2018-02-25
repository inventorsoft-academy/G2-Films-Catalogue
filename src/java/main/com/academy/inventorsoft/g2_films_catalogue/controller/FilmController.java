package academy.inventorsoft.g2_films_catalogue.controller;

import academy.inventorsoft.g2_films_catalogue.dataBase.FilmDataBase;
import academy.inventorsoft.g2_films_catalogue.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;


@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE, OPTIONS})
@RequestMapping(value = "/film")
public class FilmController {
    @Autowired
    FilmDataBase filmDataBase;


    @GetMapping(value = "/filmList")
    public List<Film> getFilms() {

        return filmDataBase.getFilms();
    }


    @GetMapping(value = "/top10")
    public List<Film> top10() {
        return filmDataBase.top10Films();
    }


    @GetMapping(value = "/top10Directors")
    public List<String> top10Director() {
        return filmDataBase.getTop10Director();
    }

    @PostMapping(value = "/newFilm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFilmtoDataBase(@RequestBody Film film) {
        System.out.println("new film");

        if (!filmDataBase.hasFilm(film.getName())){
            filmDataBase.addFilmToDataBase(film);
            filmDataBase.saveData();//TODO забрати це !!!
        }
    }

    @GetMapping(value = "/hasFilm" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity hashasFilm(@RequestParam(value = "name") String name) {
        System.out.println("hesFilm: " + name);
        if(!filmDataBase.hasFilm(name)){
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);

        }




    @GetMapping(value = "/getFilmByName" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Film getFilmByName(@RequestParam(value = "name") String name) {
        System.out.println("getFilm: " + name);
        return filmDataBase.getFilmByName(name).get();
    }




    @GetMapping(value = "/setLike", produces = MediaType.APPLICATION_JSON_VALUE)
    public void likeFilm(@RequestParam(value = "userLogin") String userLogin,
                           @RequestParam(value = "name") String name) {
        System.out.println("setLike: " + userLogin + name);

        filmDataBase.getFilmByName(name).get().likeFilm(userLogin);
        filmDataBase.saveData();

    }

    @GetMapping(value = "/setDisLike", produces = MediaType.APPLICATION_JSON_VALUE)
    public void dislikeFilm(@RequestParam(value = "userLogin") String userLogin,
                              @RequestParam(value = "name") String name) {
        System.out.println("dislike: " + userLogin + name);
        filmDataBase.getFilmByName(name).get().dislikeFilm(userLogin);
        filmDataBase.saveData();
    }


}
