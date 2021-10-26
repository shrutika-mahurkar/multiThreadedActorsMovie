
public class HollywoodMovie {

    private String actors;
    private String movie;
    private int year;

    public HollywoodMovie(String actors, String movie, int year) {
        this.actors = actors;
        this.movie = movie;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getMovie() {
        return movie;
    }

    public String getActors() {
        return actors;
    }


}

