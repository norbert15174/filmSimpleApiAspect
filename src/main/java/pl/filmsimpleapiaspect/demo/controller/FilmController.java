package pl.filmsimpleapiaspect.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filmsimpleapiaspect.demo.models.Film;
import pl.filmsimpleapiaspect.demo.services.FilmService;

import java.util.List;


@RestController
@RequestMapping(path = "/films")
public class FilmController {

    FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){

        return new ResponseEntity(this.filmService.getFilms(),HttpStatus.ACCEPTED);

    }

    @GetMapping("/id/{id}")
    public  ResponseEntity<Film> getFilmById(@PathVariable int id){
        if(this.filmService.getFilmById(id).isPresent()){
            return new ResponseEntity(this.filmService.getFilmById(id),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<Film> getFilmByName(@PathVariable String name){
        if(this.filmService.getFilmByName(name).isPresent()){
            return new ResponseEntity(this.filmService.getFilmByName(name),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<String> addFilm(@RequestBody Film film){

        if(this.filmService.addFilm(film)){
            return new ResponseEntity("Film został dodany",HttpStatus.CREATED);
        }else{
            return new ResponseEntity("Film nie został dodany",HttpStatus.NOT_ACCEPTABLE);
        }


    }







}
