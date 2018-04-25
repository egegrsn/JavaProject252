import java.util.Comparator;

public abstract class MovieComparator implements Comparator<Movie>{
    @Override
    public abstract int compare(Movie firstMovie, Movie secondMovie);
}
