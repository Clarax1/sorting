package rosbank.train;

import java.util.List;

public class Train {
    private final int weight;
    private List<Wagon> wagons;
    //массив поездов

    public Train() {
        weight = 0;
        initWagons();
    }

    private void initWagons() {

    }

    public int getWeight() {
        return weight;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void refresh(){
        //поменять вес
    }
}
