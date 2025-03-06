
import java.util.Arrays;

public class Movie {
    private String title;
    private int ProdYear;
    private String directorsName;
    private String[] actors;
    private String synopsis;

    // constructor
    public Movie(String title, int prodYear, String directorsName, String[] actors, String synopsis) {
        this.title = title;
        ProdYear = prodYear;
        this.directorsName = directorsName;
        this.actors = actors;
        this.synopsis = synopsis;
    }

    // getMovieDetails
    public String getMovieDetails() {
        return "Title: " + getTitle() + "\n" +
                "Production Year: " + getProdYear() + "\n" +
                "Director's Name: " + getDirectorsName() + "\n" +
                "Actors: " + Arrays.toString(getActors()) + "\n" +
                "Synopsis: " + getSynopsis() + "\n";
    }

    // getters
    public String getDirectorsName() {
        return directorsName;
    }

    public String[] getActors() {
        return actors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getProdYear() {
        return ProdYear;
    }

    public String getTitle() {
        return title;
    }
}
