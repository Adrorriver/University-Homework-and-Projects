
/**
 * the DayInWeek class gets date and writes the day of the week for that date. 
 * 
 * @author (Amir dror). 
 * 
 */
import java.util.Scanner;
public class DayInWeek
{
    /**
     * gets date in three different parts- day, month,year.
     * checks for legality.
     * fitting them for the equation.
     * calculates the date.
     * print the day of the week.
     * 
     */
    public static void main(String[]args)
    {
        //gets date in three different parts- day, month,year.
        Scanner scan = new Scanner(System.in);
        System.out.println("the program calculates the day of the week for a given date ");
        System.out.println("please enter day in month 1-31");
        int dayInMonth = scan.nextInt();
        System.out.println("please enter month 1-12 ");
        int month = scan.nextInt();
        System.out.println("please enter year ");
        int year = scan.nextInt();
        
        // checks legality.
        
        if ((dayInMonth>31) || (dayInMonth<1))
            dayInMonth = 1;
        if ((month>12) || (month<1))
            month = 1;
        if ((year<0) || (year>9999)) 
            year = 1; 
            
        //fitting variables for the equation.
        
        if (( month == 1) || (month == 2))
            {
            month = month + 12;
            year = year-1;
            }
        int yearLast2 = (year % 100);
        int yearfirst2 = (year / 100);
        
        //calculates the date.
        
        int  day = (dayInMonth+ (26* (month + 1))/ 10+ yearLast2+ yearLast2/4+ yearfirst2/4 - 2*yearfirst2)%7;
        
        // print the day of the week.
        switch (day)
        {
            
            case 1: System.out.println("Sunday");
            break;
            case 2: System.out.println("Monday");
            break;
            case 3: System.out.println("Tuesday");
            break;
            case 4: System.out.println("Wednesday");
            break;
            case 5: System.out.println("Thursday");
            break;
            case 6: System.out.println("Friday");
            break;
            case 0: System.out.println("Saturday");
            break;
            // equation correction 
            case -6: System.out.println("Sunday");
            break;
            case -5: System.out.println("Monday");
            break;
            case -4: System.out.println("Tuesday");
            break;
            case -3: System.out.println("Wednesday");
            break;
            case -2: System.out.println("Thursday");
            break;
            case -1: System.out.println("Friday");
            break;
     
        }
    }// end of method main.
    
   
}//end of class DayInWeek.
