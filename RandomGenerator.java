import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class RandomGenerator {
    public static void main(String[] args) {
        
        int[] numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            int randomNumber = random.nextInt(1000);
            numbers[i] = numbers[randomNumber];
            numbers[randomNumber] = temp;
        }
        try {
            PrintWriter fileWriter = new PrintWriter("RandNumb.txt");
            for (int i = 0; i < numbers.length; i++) {
                fileWriter.println(numbers[i]);
            }
            fileWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
}

