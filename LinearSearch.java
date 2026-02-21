import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LinearSearch {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scfl = new Scanner(new File("RandNumb.txt"));
        int[] arr = new int[1000];
        int i = 0;
        while(scfl.hasNextInt()){
            arr[i] = scfl.nextInt();
            i++;
        }
        scfl.close();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target number:");
        int target = sc.nextInt();
        long start = System.nanoTime();
        int targetIndex = -1;
        for (int j = 0 ; j < arr.length ; j++){
            if (arr[j] == target){
                targetIndex = j;
                break;
            }
        }
        long end = System.nanoTime();
        double totalSecs = (end - start)/1_000_000_000.0;
	System.out.println("Minh Vu, gzq766");        
	if(targetIndex == -1){
            System.out.println("Target number not found\nLinear search runtime: " + totalSecs + " seconds.");
        }
        else{
            System.out.println("Number " + target + " is found at index " + targetIndex);
            System.out.println("Linear search runtime: " + totalSecs + " seconds.");
        }
    }

}

