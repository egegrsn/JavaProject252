
public class Director extends Person{
	public Movie moviesDirected;
	
	public Director(String name, int birthYear, int awardCount,int movieId) {
		super(name, birthYear, awardCount,movieId);
		// TODO Auto-generated constructor stub
	}

	public Movie getMoviesDirected() {
		return moviesDirected;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Director director = (Director) o;

		return moviesDirected != null ? moviesDirected.equals(director.moviesDirected) : director.moviesDirected == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (moviesDirected != null ? moviesDirected.hashCode() : 0);
		return result;
	}

	@Override
	public String toString(){
		return "|Director|\nName : " + getName()
				+ "\nBirth Year : " + getBirthYear()
				+ "\nAward Count : " + getAwardCount();
	}
}
