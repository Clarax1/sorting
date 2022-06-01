package rosbank;

public class Main {

    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }


    }

    public static void main(String[] args) {
        int a[] = new int [482310];

        new Main().bubbleSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
