
public class Director extends Person{
	public Movie moviesDirected;
	
	public Director(String name, int birthYear, int awardCount,int movieId) {
		super(name, birthYear, awardCount,movieId);
		// TODO Auto-generated constructor stub
	}

	public Movie getMoviesDirected() {
		return moviesDirected;
	}
}
