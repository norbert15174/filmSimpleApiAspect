package pl.filmsimpleapiaspect.demo.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Film {


    @NotNull
    private int id;


    @NotNull
    @Min(2)
    private String name;

    @Min(1900)
    @Max(2021)
    @NotNull
    private int production_year;
    @NotNull
    @Min(4)
    private String director;

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", production_year=" + production_year +
                ", director='" + director + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film(String name, int production_year, String producer, int id) {

        this.name = name;

        this.production_year = production_year;

        this.director = producer;
        this.id = id;
    }

    public Film() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String producer) {
        this.director = producer;
    }
}
