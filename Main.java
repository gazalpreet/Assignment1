/*  Gazalpreet Guddu
    This class asks for user input from main() and calculates the fibonacci sequence
    Both recursively using fiboSeriesRec() and iteratively using fiboSeriesIte()
    Assumption: User will only input numbers and not other characters
    */

//Explicitly import the Scanner and TimeUnit for reading user input and elapsed time, respectively
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Variable read to take in user input
        Scanner read = new Scanner(System.in);

        //Ask user for nth value
        System.out.print("Please enter a number: ");
        float n = read.nextFloat();

        if (n>=0) {
            //Call recursive method
            System.out.println("Recursive Method: ");
            long starttime = System.nanoTime();
            fiboSeriesRec(n, 1, 0, 0);
            long endtime = System.nanoTime();

            long timeElapsed = endtime - starttime;
            System.out.println("\nRecursive Method Execution Time: " + timeElapsed + " ns");

            //Call iterative method
            System.out.println("\n" + "Iterative Method: ");
            starttime = System.nanoTime();
            fiboSeriesIte(n);
            endtime = System.nanoTime();

            timeElapsed = endtime - starttime;
            System.out.println("\nIterative Method Execution Time: " + timeElapsed + " ns");
        }
        else
            System.out.println("Number cannot be less than 0");
    }

    //Name: fiboSeriesRec
    //Parameters (name (type)): n (float), third(int) second (int), first (int)
    //Prints the fibonacci sequence till the n value using recursion
    //Repeatedly calls itself while first is less than n, and prints the calculated value of first
    private static void fiboSeriesRec(float n, int third, int second, int first) {
        if (first<n) {
            first += second;
            second = third;
            third = first;
            if (first<n)
                System.out.print(first+" ");
            fiboSeriesRec(n, third, second, first);
        }
    }

    //Name: fiboSeriesIte
    //Parameters (name (type)): n (float)
    //Prints the fibonacci sequence till the nth value using iteration
    //For loop runs while first is less than n, and prints the calculated value of first
    private static void fiboSeriesIte(float n)
    {
        int second;
        int third = 1;
        for(int first = 0; first<n; first += second)
        {
            second= third;
            third = first;
            if (first<n)
                System.out.print(first+" ");
        }
    }
}

