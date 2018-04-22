
public class Movie {

	private String name;
	private int year;
	private String genre;
	private Director director;
	private double rating;
	private Actor actorArray;
	private int movieId;
	
	public Movie(String name, int year, String genre, Director director, double rating, Actor actorArray, int movieId) {
		super();
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.actorArray = actorArray;
		this.movieId = movieId;
	}
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", genre=" + genre + ", director=" + director + ", rating="
				+ rating + ", actorArray=" + actorArray + ", movieId=" + movieId + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorArray == null) ? 0 : actorArray.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actorArray == null) {
			if (other.actorArray != null)
				return false;
		} else if (!actorArray.equals(other.actorArray))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (movieId != other.movieId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Actor getActorArray() {
		return actorArray;
	}

	public void setActorArray(Actor actorArray) {
		this.actorArray = actorArray;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}




	
}
