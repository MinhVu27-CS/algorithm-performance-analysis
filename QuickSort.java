import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSort {
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot_index = partition(arr, start, end);
        quickSort(arr, start, pivot_index - 1);
        quickSort(arr, pivot_index + 1, end);
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
        System.out.println("Minh Vu, gzq766");
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        double secs = (end-start)/1_000_000_000.0;
        System.out.println("Quick Sort runtime: " + secs + " seconds");

        PrintWriter fileWriter = new PrintWriter("sortednumb.txt");
        for (int j=0;j<arr.length;j++){
            fileWriter.println(arr[j]);
        }
        fileWriter.close();

    }
}

