
/**
 * Tester
 * 
 */
public class Tester16
{

    
    
    
    
    
    
    //question number 1 test
    public static void main (String [] args)   
    {
        int [] arr = {2,77,6,2,55,4,0,1,3,89};
        printArr (arr);
        Ex16.sortByFour (arr);
        printArr (arr);
    } //question number 1 test
    
    
    
    
       
    //question number 2 test
   
    public static void printArr (int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print (arr[i]+ ", ");
            System.out.println();
    }
    /*
    public static void main (String [] args)
    {
        String s = "ccabc";
        char c = 'c';
        System.out.print(subStrMaxC (s,c,6));
        
    }
    
    
     */
    /*
    // test question number 3  
    
    public static void main (String [] args)
    {
     char[] findIn = {'q', 'e', 'a','q','e','v', 'r', 'q', 'e', 'l'};
     char[] toFind = { 'q', 'e', 'g'};
     System.out.print(Ex16.findSequence(findIn,toFind));
        
    }
    
    */
   
   
    // test question number 4
    /*
    public static void main (String [] args)
    {
     boolean[] init = {true, false, true, false, true };
     boolean[] target = { false, false, true, false, true };
        System.out.print(Ex16.disco(init,target));
        
    }
    
    */
    
    
}



