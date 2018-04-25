public class ActorAwardCountComparator extends ActorComparator {
    @Override
    public int compare(Actor firstActor, Actor secondActor){
        return (firstActor.getAwardCount() - secondActor.getAwardCount());
    }
}
