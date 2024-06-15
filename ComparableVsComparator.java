import java.util.*;

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(double rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.year - movie.year;
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(8.3, "Force Awakens", 2015));
        list.add(new Movie(8.7, "Star Wars", 1977));
        list.add(new Movie(8.8, "Empire Strikes Back", 1980));
        list.add(new Movie(8.4, "Return of the Jedi", 1983));

        System.out.println("Movies after sorting : ");
        Collections.sort(list);
        for (Movie movie : list) {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
