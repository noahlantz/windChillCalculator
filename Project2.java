/******************************************************************
 * CS21 - Java Programming
 * Author: Noah Lantz
 * Assignment: Project 2
 * Instructor: Prof. Kyle Muldrow
 *
 * Name of class: CS 21 Intro to Computer Science-Java - 32505
 *******************************************************************
 */

//import the utility for our scanner and special functions
import java.util.*;
public class Project2
{
   public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter starting temperature(F): ");
        double temp = kb.nextDouble(); //user enters temp here that will be stored for the program
        
        double wcvelocity = (double)(getVelocity(kb));//passes scanner object to method, returns value
        int wctemp = (int)temp; //typecast to eventually send as an int parameter to wcfactor()
        System.out.println("Current Temp\tWind Speed\tWind Chill Factor\tFeels Like");
        System.out.println("------------------------------------------------------------------");
        
        for (int x = 1; x <= wcvelocity; x++) {
            double xdouble = (double)x;
            double chillfactor = wcfactor(wctemp,xdouble);
            int finalwind = x;
            int feelslike = (int)(Math.round(chillfactor));
            System.out.printf("%5d F"+ "%12d MPH"+"%19.2f"+"%19d F",wctemp,finalwind,chillfactor,feelslike);
            System.out.println();
        }//for loop to loop through every line needed to output specified range
        
    }// end of main
    
   public static int getVelocity(Scanner kb) {
        System.out.println("Enter maximum wind speed(MPH): ");
        int windspeed = kb.nextInt(); 
        
        while (windspeed < 2 || windspeed > 50) {
            System.out.print("Please enter a valid number between 2 and 50: ");
            windspeed = kb.nextInt(); 
        }//to ensure user enters valid value
        return windspeed; 
    }//end of getVelocity
    
   public static double wcfactor(int temp, double velocity){
       double windchill = 35.74 + (0.6215 * temp) - (35.75 * Math.pow(velocity,0.16)) + (0.4275 * temp * Math.pow(velocity,0.16));
        return windchill;   
    }// end of wcfactor
    
}//end of class
