package Java_8_Features;

import java.util.ArrayList;
import java.util.Collections;

// How compareTo works:
// Returns a negative value if the current object (i.e., this) is less than the object being compared (o).
// Returns zero if the current object is equal to o.
// Returns a positive value if the current object is greater than o.

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public Movie(String name, double rating, int year) {
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
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        ArrayList<Movie> moviewList = new ArrayList<Movie>();
        moviewList.add(new Movie("Force Awakens", 8.3, 2015));
        moviewList.add(new Movie("Star Wars", 8.7, 1977));
        moviewList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        moviewList.add(new Movie("Return of the Jedi", 8.4, 1983));
        Collections.sort(moviewList);
        System.out.println("Moview after sorting");
        for (Movie movie : moviewList) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
        // -----------------------------
        System.out.println();
        Integer a = 30;
        Integer b = 20;
        Integer c = Integer.compare(a, b);
        System.out.println(c);
    }
}
