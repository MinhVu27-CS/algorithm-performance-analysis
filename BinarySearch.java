import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scfl = new Scanner(new File("sortednumb.txt"));
        int[] arr = new int[1000];
        int i = 0;
        while (scfl.hasNextInt()) {
            arr[i] = scfl.nextInt();
            i++;
        }
        scfl.close();
        Scanner sc = new Scanner(System.in);
        System.out.println("Minh Vu, gzq766");
        System.out.println("Enter target number:");
        int target = sc.nextInt();
        sc.close();
        long start = System.nanoTime();
        int targetIndex = binarySearch(arr, target);
        long end = System.nanoTime();
        double secs = (end-start)/1_000_000_000.0;
        if(targetIndex == -1){
            System.out.println("Target number not found\nBinary Search runtime: " + secs + " seconds.");
        }
        else{
            System.out.println("Number " + target + " is found at index " + targetIndex);
            System.out.println("Binary Search runtime: " + secs + " seconds.");
        }

    }
}

