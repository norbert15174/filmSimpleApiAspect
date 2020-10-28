package pl.filmsimpleapiaspect.demo.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.filmsimpleapiaspect.demo.aspects.FilmAnnotation;
import pl.filmsimpleapiaspect.demo.models.Film;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class FilmService {

    List<Film> films = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    public void initSomeFilms(){
        films.add(new Film("The Prestige",2006,"Christopher Nolan",1));
        films.add(new Film("Polityka",2019,"Patryk Vega",2));
        films.add(new Film("Bright",2017," David Ayer",3));
        films.add(new Film("El Camino: A Breaking Bad Movie",2019,"Vince Gilligan",4));
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public Optional<Film> getFilmByName(String name){
        return this.films.stream().filter(film -> film.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Film> getFilmById(int id){
        return this.films.stream().filter(film -> film.getId() == id).findFirst();
    }


    @FilmAnnotation
    public boolean addFilm(Film film){
        if(this.films.stream()
                .filter(checkFilm  -> checkFilm.getId() == film.getId())
                .findFirst()
                .isPresent()){
            return false;
        }else {
            films.add(film);
            return true;
        }
    }





}
