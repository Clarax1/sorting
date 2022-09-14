package rosbank.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorter {
    public Integer[] bubbleSort(Integer[] array) {
        if (array.length<2){
            throw new AssertionError("Bad array");
        }
        var list=Stream.of(array).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        var result=new Integer[list.size()];
        list.toArray(result);
        var randArray1 = ThreadLocalRandom.current().nextInt(array.length);


        var randArray2 = ThreadLocalRandom.current().nextInt(array.length);
        while (randArray2 == randArray1) {
            randArray2 = ThreadLocalRandom.current().nextInt(array.length);
        }

        var buf = result[randArray1];
        result[randArray1] = result[randArray2];
        result[randArray2] = buf;


        System.out.println(Arrays.toString(result));
        return result;
    }
}
