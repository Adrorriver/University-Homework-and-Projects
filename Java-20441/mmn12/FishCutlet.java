

/**
 * The Fishcutlet class prints calculation of the time needed for cooking Fish cutlet.
 * 
 * @author (Amir Dror 034648485) 
 * 
 */

import java.util.Scanner;
public class FishCutlet
{
    /** 
     * notified the time needed for making 1 fish cutlet
     * Gets nunber of fish cutlet to make
     * Calculates the time needed
     * Prints the time needed
     */
    public static void main (String[]args)
    {
        final int HEATING_TIME = 20;
        
        //Gets number of fish cutlet from user
        
        Scanner scan = new Scanner(System.in);
        System.out.println ("It takes " +HEATING_TIME+ " seconds to heat one fish cutlet. ");
        System.out.println ("How many cutlets would you like to heat? ");
        int num = scan.nextInt();
        
        //time calculation- total, minutes, seconds 
        int totalTime = num * HEATING_TIME;
        int timeMinutes =  totalTime / 60 ;
        int timeSeconds = totalTime % 60;
        
        //output
        System.out.println ("You need to heat the cutlets for "+ timeMinutes +" minute and "+ timeSeconds +" seconds.");
        
        
    } // end of method main
} //end of class FishCutlet
