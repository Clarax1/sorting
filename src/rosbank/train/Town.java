package rosbank.train;

public class Town implements ICanBeVisited{
    @Override
    public void visit(Train train) {
        train.getWagons().forEach(Wagon::apply);
        train.refresh();
    }
}
