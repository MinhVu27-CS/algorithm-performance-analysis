import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
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
        mergeSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        double secs = (end - start)/1_000_000_000.0;
        System.out.println("Minh Vu, gzq766");
	System.out.println("Merge Sort runtime: " + secs + " seconds");

        PrintWriter fileWriter = new PrintWriter("sortednumb.txt");
        for (int j=0;j<arr.length;j++){
            fileWriter.println(arr[j]);
        }
        fileWriter.close();

    }
}

