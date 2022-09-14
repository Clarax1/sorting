package rosbank.sorting;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSorter {
    private final static Sorter sorter = new Sorter();

    private static void testEmpty() {
        Integer[] arr = {};
        sorter.bubbleSort(arr);
    }

    private static void testSingle() {
        Integer[] arr = {1};
        sorter.bubbleSort(arr);
    }

    private static void testSorting() {
        var arraySize = ThreadLocalRandom.current().nextInt(2, 50);
        var array = new Integer[arraySize];
        for (var i = 0; i < arraySize; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        var temp=Stream.of(array).distinct().collect(Collectors.toList());
        if (temp.size()<2){
            testSorting();
            return;
        }
        array=new Integer[temp.size()];
        temp.toArray(array);
        var sorted=sorter.bubbleSort(array);
        var list=List.of(sorted);
        var trueSorted=Arrays.stream(array).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        if (!new HashSet<>(trueSorted).containsAll(list)){
            throw new RuntimeException("Changed value");
        }

        if (list.equals(trueSorted)){
            System.out.println("[");
            System.out.println(Arrays.toString(array));
            System.out.println(list);
            System.out.println(trueSorted);
            System.out.println("]");
            throw new RuntimeException("Bad sorting");

        }
        if (list.size()!=trueSorted.size()){
            throw new RuntimeException("Lost element");
        }
        var cache=new ArrayList<Integer>();
        for (var i=0;i<list.size();i++){
            if (!list.get(i).equals(trueSorted.get(i))){
                cache.add(i);
            }
        }
        if (cache.size()!=2){
            throw new RuntimeException("Bad defect");
        }
        if (!list.get(cache.get(0)).equals(trueSorted.get(cache.get(1)))){
            throw new RuntimeException("Bad switch 1");
        }
        if (!list.get(cache.get(1)).equals(trueSorted.get(cache.get(0)))){
            throw new RuntimeException("Bad switch 1");
        }
    }

    private static void bigTest(){
        for (var i=0;i<10000;i++){
            testSorting();
        }
    }

    private static void run(Runnable runnable) {
        try {
            runnable.run();
            System.out.println("Good");
        } catch (Throwable any) {
            if (any instanceof AssertionError) {
                System.out.println("Good");
                return;
            }
            System.out.println(any.getMessage());
            System.out.println("Bad");
        }
    }


    public static void main(String[] args) {
        Stream.<Runnable>of(
                        TestSorter::testEmpty,
                        TestSorter::testSingle,
                        TestSorter::testSorting,
                        TestSorter::bigTest)
                .forEach(TestSorter::run);
    }
}
