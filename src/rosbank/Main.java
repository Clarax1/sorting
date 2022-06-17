package rosbank;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }

        Random rand = new Random();
        int randArray = rand.nextInt(array.length-1);
        buf = array[randArray];
        array[randArray] = array[randArray+1];
        array[randArray+1] = buf;

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {

        int a[] = new int[] {4,8,2,3,1,0};

        new Main().bubbleSort(a);

    }
}
