
public class Actor extends Person {

	private Movie moviesAct;

	public Actor(String name, int birthYear, int awardCount) {
		super(name, birthYear, awardCount);
		// TODO Auto-generated constructor stub
	}

	public Movie getMoviesAct() {
		return moviesAct;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Actor actor = (Actor) o;

		return moviesAct != null ? moviesAct.equals(actor.moviesAct) : actor.moviesAct == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (moviesAct != null ? moviesAct.hashCode() : 0);
		return result;
	}

	@Override
	public String toString(){
		return "|Actor|\nName: " + getName()
				+ "";
	}
}
