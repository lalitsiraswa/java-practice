package Java_8_Features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() < m2.getRating())
            return -1;
        else if (m1.getRating() > m2.getRating())
            return 1;
        else
            return 0;
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName());
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

        // Sort by rating :
        // (1) Create an object of ratingCompare
        // (2) Call Collections.sort
        // (3) Print Sorted list
        System.out.println();
        System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(moviewList, ratingCompare);
        for (Movie movie : moviewList) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
        // Sort by Movie Name :
        // (1) Create an object of NameCompare
        // (2) Call Collections.sort
        // (3) Print Sorted list
        System.out.println();
        System.out.println("Sorted by rating");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(moviewList, nameCompare);
        for (Movie movie : moviewList) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }
}
