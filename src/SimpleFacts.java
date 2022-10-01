import java.util.*;
import java.util.Scanner;
import java.lang.Thread;
import java.util.Collections;

public class SimpleFacts {
    private Scanner scanner = new Scanner(System.in);
    private double sum = 0;
    private ArrayList<Integer> numList = new ArrayList<Integer>(6);

    /**
     * Postcondition: Sorts numList and calculates median
     */
    public void calculateMedian() {
        Collections.sort(numList);
        Collections.reverse(numList);
        System.out.println(((numList.get((2)) + (numList.get(3)))) / 2);
    }

    /**
     * Postcondition: Prints sum and total of six numbers inputted by the user
     */
    public void showFacts() {
        for (int i = 0; i < 6; i++) {
            System.out.print("Please give me a number: ");
            numList.add(Integer.parseInt(scanner.nextLine()));
            sum += numList.get(i);
            System.out.println("The sum is: " + sum);
        }
        // Thread.sleep() must be wrapped in try/catch to run without error

        try {
            System.out.print("Calculating");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.print("The average is: ");
        System.out.printf("%.2f", sum / 6);
        System.out.println();

        calculateMedian();

    }

    public static void main(String[] args) {
        SimpleFacts numSimpleFacts = new SimpleFacts();

        numSimpleFacts.showFacts();
    }
}
