/*
    Programmer : Anthony D'Ambrosio

    Date       : 9/21/2015

    Purpose    : This program gets the mean and standard deviation from 
                 a random amount of integers in a .txt file.

    Limitations: If the file "input.txt" does not exist wherever the .java 
                 is saved, this program will crash.
*/

//package lab04;
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Lab04
{
    static Scanner console = new Scanner(System.in);
    
    public static void main( String[] args ) throws FileNotFoundException
    {
        // Declaring variables. 
        Scanner inFile = new Scanner(new FileReader("input.txt"));
        
        double mean,
               standardDeviation;
        
        String input,
               fileName;
        
        
        // Initalizing variables. 
        fileName = "input.txt";
        
        input = inFile.nextLine();
        inFile.close();
        
        
        // Computes the mean and standard deviation.
        mean = computeMean(fileName);
        standardDeviation = computeStandardDeviation(fileName, mean);
        
        
        // Prints out the input, mean, and standard deviation to the console.
        System.out.println("Input: " + input);
        System.out.printf("The mean is %.2f%n", mean);
        System.out.printf("The standard deviation is %.2f%n", 
                standardDeviation);
        
    }
    
    
    // This method computes the mean. 
    public static double computeMean(String fileName) 
            throws FileNotFoundException
    {
        // Declaring variables. 
        Scanner inFile = new Scanner(new FileReader(fileName));
        
        double mean;
        
        int counter,
            totalCount;
        
        
        // Initialzing variables as 0s.
        totalCount = 0;
        mean = 0;
        
        
        // Sets loop counter to 0.
        // Runs until that file line hsa no more ints.
        // increments counter by one to get how many ints were on that line.
        // Loop adds all the numbers in the line together.
        for ( counter = 0; inFile.hasNext();counter++)
        {
            mean = mean + inFile.nextInt();
            totalCount = counter;
           
            
        }
        
        // Now we divide by the total amount of integers in that line.
        mean = mean / (totalCount + 1);
        
        // Closes the file.
        inFile.close();
        
        // Returns mean to main.
        return mean;
    }
    
    
    // This method computes the standard deviation.
    public static double computeStandardDeviation(String fileName, double mean) throws FileNotFoundException
    {
        // Decalring variables. 
        Scanner inFile = new Scanner(new FileReader(fileName));

        double standardDeviation;
        int totalCount,
            counter;

        
        //Initalizing variables.
        standardDeviation = 0;
        
        totalCount = 0;
        
        
        // Sets counter to 0.
        // Runs until no more ints in that line.
        // Increments counter.
        // Subtracts the mean from each integer, then squares the result,
        // and adds them all up.
        for ( counter = 0; inFile.hasNext(); counter ++)
        {
            standardDeviation = standardDeviation + 
                    pow( ( inFile.nextInt() - mean ), 2 );
            
            totalCount = counter;
            
       }
        
        
        // Now we take the result from the loop, divide by the num of ints,
        // and take the square root.
        standardDeviation = sqrt( ( standardDeviation / ( totalCount + 1 ) ) );
        
        
        // Closes the file.
        inFile.close();
        
        
        // returns the square root.
        return standardDeviation;
    }
}
  
