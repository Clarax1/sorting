package rosbank.train;

import java.util.concurrent.ThreadLocalRandom;

public enum WagonType {
    //TODO типы и размеры
    A("Пассажирский", 200, 400), B("Холодильник", 200, 400), C("Контейнер", 200, 400);

    private final String type;
    private final int weight;
    private final int maxweght;

    WagonType(String type, int weight, int maxweght) {
        this.type = type;
        this.weight = weight;
        this.maxweght = maxweght;
    }

    public Wagon generate(){
        return new Wagon(type, weight,  ThreadLocalRandom.current().nextInt(0,maxweght));
    }
}
