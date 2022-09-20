package rosbank.train;

import java.util.concurrent.ThreadLocalRandom;

public enum WagonType {
    //TODO типы и размеры
    A("Пассажирский", 2, 200, 2), B("Холодильник", 7, 250, 7), C("Контейнер", 4, 300, 4);

    private final String type;
    private final int weight;
    private final int maxweght;
     private int foolWeight;

    WagonType(String type, int weight, int maxweght, int foolWeight) {
        this.type = type;
        this.weight = weight;
        this.maxweght = maxweght;
    }

    public Wagon generateVagon(){
        return new Wagon(type, weight, maxweght, foolWeight=(weight + ThreadLocalRandom.current().nextInt(0,(maxweght - weight))));
    }
}
