import java.util.Comparator;

public abstract class ActorComparator implements Comparator<Actor>{
    @Override
    public abstract int compare(Actor firstActor, Actor secondActor);
}
