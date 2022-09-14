package rosbank.train;

import java.util.Arrays;

public class World {
    private Train train;
    private ICanBeVisited[] places;
    public void run() {
        initTrain();
        initPlaces();
        Arrays.stream(places)
                .forEach(place -> place.visit(train));
    }

    private void initPlaces() {
    }

    private void initTrain() {
    }
}
