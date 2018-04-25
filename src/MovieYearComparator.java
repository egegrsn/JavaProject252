public class MovieYearComparator extends MovieComparator {
    @Override
    public int compare(Movie firstMovie, Movie secondMovie){
        return (firstMovie.getYear() - secondMovie.getYear());
    }
}
