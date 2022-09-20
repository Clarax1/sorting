package rosbank.train;

import java.util.concurrent.ThreadLocalRandom;

public enum BridgeType {
    //TODO типы и размеры
    A("Каменный", 200, 400), B("Деревянный", 200, 400), C("Бетонный", 200, 400);

    private final String material;
    private final int weightLow;
    private final int weightMax;

    BridgeType(String material, int weightLow, int weightMax) {
        this.material = material;
        this.weightLow = weightLow;
        this.weightMax = weightMax;
    }

    public Bridge generateBridge(){
        return new Bridge(material,ThreadLocalRandom.current().nextInt(weightLow,weightMax));
    }
}
