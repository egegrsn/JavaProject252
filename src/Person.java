
public class Person {

	private String name;
	private int birthYear;
	private int awardCount;
	
	public Person(String name, int birthYear, int awardCount) {
		
		this.name = name;
		this.birthYear = birthYear;
		this.awardCount = awardCount;
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
	public String toString(){
		return "";
	}
}
