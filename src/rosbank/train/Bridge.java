package rosbank.train;

import java.util.function.Predicate;

public class Bridge implements ICanBeVisited {
    private final String material;
    private final int weight;

    public Bridge(String material, int nextInt) {
        this.material = material;
        this.weight = nextInt;
    }

    public void visit(Train train) {
        if (train.getWeight()<=weight){
            throw new RuntimeException("Train was too heavy");
        }
    }
}
