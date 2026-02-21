import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scfl = new Scanner(new File("RandNumb.txt"));
        int[] arr = new int[1000];
        int i = 0;
        while(scfl.hasNextInt()){
            arr[i] = scfl.nextInt();
            i++;
        }
        scfl.close();
        long start = System.nanoTime();
        bubbleSort(arr);
        long end = System.nanoTime();
        double secs = (end - start) / 1_000_000_000.0;
	System.out.println("Minh Vu, gzq766");
        System.out.println("Bubble Sort runtime: " + secs + " seconds");
        PrintWriter fileWriter = new PrintWriter("sortednumb.txt");
        for (int j=0;j<arr.length;j++){
            fileWriter.println(arr[j]);
        }
        fileWriter.close();

    }
}

