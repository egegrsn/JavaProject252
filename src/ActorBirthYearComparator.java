public class ActorBirthYearComparator extends ActorComparator {
    @Override
    public int compare(Actor firstActor, Actor secondActor){
        return (firstActor.getBirthYear() - secondActor.getBirthYear());
    }
}
