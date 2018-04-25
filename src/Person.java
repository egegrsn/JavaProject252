
public class Person implements Comparable<Person>{

	private String name;
	private int birthYear;
	private int awardCount;
	private int movieId;

	public Person(String name, int birthYear, int awardCount, int movieId) {
		
		this.name = name;
		this.birthYear = birthYear;
		this.awardCount = awardCount;
		this.movieId= movieId;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getAwardCount() {
		return awardCount;
	}
	
	public int getMovieId() {
		return movieId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (birthYear != person.birthYear) return false;
		if (awardCount != person.awardCount) return false;
		return name != null ? name.equals(person.name) : person.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + birthYear;
		result = 31 * result + awardCount;
		return result;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthYear=" + birthYear + ", awardCount=" + awardCount + ", movieId="
				+ movieId + "]";
	}

	@Override
	public int compareTo(Person o) {
		return getName().compareTo(o.getName());
	}
}

	
