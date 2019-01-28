/*  Gazalpreet Guddu
    This class asks for user input from main() and calculates the fibonacci sequence
    Both recursively using fiboSeriesRec() and iteratively using fiboSeriesIte()
    Assumption: User will only input numbers */

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

            //Calculate and output the elapsed time for the recursive method
            long timeElapsed = endtime - starttime;
            System.out.println("\nRecursive Method Execution Time: " + timeElapsed + " ns");

            //Call iterative method
            System.out.println("\n" + "Iterative Method: ");
            starttime = System.nanoTime();
            fiboSeriesIte(n);
            endtime = System.nanoTime();

            //Calculate and output the elapsed time for the iterative method
            timeElapsed = endtime - starttime;
            System.out.println("\nIterative Method Execution Time: " + timeElapsed + " ns");
        }
        //Else statement in case user input is negative
        else
            System.out.println("Number cannot be less than 0");
    }

    //Name: fiboSeriesRec
    //Parameters (name (type)): n (float), third(int) second (int), first (int)
    //Prints the fibonacci sequence till the n value using recursion
    //Repeatedly calls itself while first is less than n, and prints the calculated value of first
    private static void fiboSeriesRec(float n, int third, int second, int first) {
        //Checks if current total stored in first is less than user input and adds the last two values together
        if (first<n) {
            //Last two values of the fibonacci sequence is stored in second and third
            first += second;
            second = third;
            third = first;
            if (first<n)    //Checks and prints the value if it is less than the user input
                System.out.print(first+" ");
            fiboSeriesRec(n, third, second, first);     //Returns the user inputs, the last two values and the new total
        }
    }

    //Name: fiboSeriesIte
    //Parameters (name (type)): n (float)
    //Prints the fibonacci sequence till the nth value using iteration
    //For loop runs while first is less than n, and prints the calculated value of first
    private static void fiboSeriesIte(float n)
    {
        //second and third will store the last two fibonacci values
        int second;
        int third = 1;
        //Runs the loop while first is less than the user input; first keeps the calculated total value
        for(int first = 0; first<n; first += second)
        {
            second= third;
            third = first;
            if (first<n)    //Checks and prints the value if it is less than the user input
                System.out.print(first+" ");
        }
    }
}

