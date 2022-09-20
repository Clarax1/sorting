package rosbank.train;

import java.util.concurrent.ThreadLocalRandom;

public class Wagon {
    private final String type;
    private final int weight;
    private final int maxweght;
    private int foolWeight;

    public Wagon(String type, int weight, int nextInt, int foolWeight) {
        this.type = type;
        this.weight = weight;
        this.maxweght = nextInt;
        this.foolWeight = foolWeight;
    }
    public void apply() {
        foolWeight = foolWeight + ThreadLocalRandom.current().nextInt(0,(maxweght - foolWeight));
    }
}
