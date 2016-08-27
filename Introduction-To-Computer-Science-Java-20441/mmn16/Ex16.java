
/**
 *  class Ex16.
 * 
 * @author (amir dror) 
 * @version (4.6.2012)
 */
public class Ex16
{
     // question number 1 *******************************************************
    public static void sortByFour (int[] arr)
    {
        int border0 = -1;
        int border1 = -1;
        int border2 = -1;
        int border3 = arr.length;
        
        for (int i = 0; i < border3; i++) // from the start 0, to the end of unnown place border3
        {
            switch (arr[i]% 4)
            {
                case 0:
                {
                    border2++; 
                    border1++;
                    border0++;
                    swap (border2, border1, arr); // swap place 2 to 1
                    swap (border1, border0, arr); // swap place 1 to 0
                    break;
                }
                
                 case 1:
                {
                    border2++;
                    border1++;
                    swap (border2, border1, arr);
                    break;
                }
                
                case 2:
                {
                    border2++;
                    break;
                }
                
                case 3:
                {
                    border3--; // move the end to the left
                    swap (i, border3, arr);
                    i--; // chack again in the same place, that now have an unnown number
                    break;
                }
            }
        }
    }
    
    public static void swap (int a, int b, int [] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    
    
    
    
    
    
    
    // question number 2 *******************************************************
    public static int subStrC (String s, char c)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c) count++;
        }
        if (count > 2) return count - 2; // if count = 0,1,2 then return 0
        else return 0;
    }
    
    public static int subStrMaxC (String s, char c, int k)
    {
        int count = 0, countmax = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c) count++;
        }
        
        if (count < 2) return 0; // if count = 0,1 then return 0
        if (k > count -2 ) k = count -2; // the relevant max is count -2  
        for (int i = 0; i <= k; i++) // runs k times
        {
        countmax += count - 1; //each time adds count - 1
        count--; 
        }
        return countmax;
    }
    
    
    
    // question number 3 ********************************************
    public static boolean findSequence (char [] findIn, char [] toFind)
    {
        int start = 0;
        int length = toFind.length;
        
        return findSequence (findIn, toFind, start, length);
    }
    
    public static boolean findSequence (char [] findIn, char [] toFind, int start, int length)
    {
        if (start > findIn.length - length) return false; // bound barrier
        if (isThere(findIn,toFind,start,length,0)) return true; // good result barrier
        
        return findSequence (findIn,toFind,start +1, length); // recoursive call start from findIn next letter 
    }
    
    public static boolean isThere (char [] findIn, char [] toFind, int start, int length, int count)
    {
        if (length <=0) return true; //  bound barrier all the chars were mach
        if (findIn[start] != toFind[count]) return false; // bad result barrier
        
        return isThere(findIn,toFind,start + 1,length - 1,count + 1); /* recoursive call,
        the letter mach, chack the next letter for bouth findIn toFind */
    }
    
    
    
    
    
    
    
    
    
    
    // question number 4 back tracking********************************************
    public static boolean disco (boolean []init, boolean[] target)
    {
        int start = 0;
        return disco (init, target, 0);
    }
    
    public static boolean disco (boolean []init, boolean[] target, int start)
    {
        if (equals(init, target,0))return true; // good result barrier
        if (start >= init.length)return false; //bound barrier
       
        push(init, start);
        if (disco (init, target, start+1)) return true; // first  option
        push(init, start);
        return (disco (init, target, start+1)); // secound option 
    }
    
    public static boolean equals(boolean[] init, boolean[] target, int index)
    {
        if (index >= init.length) return true;
        if (init[index] != target[index]) return false;
        
        return equals(init, target, index + 1);
    }
    
    public static void push (boolean[] init, int start)
    {
        init [start] = (!init [start]);
        if (start != 0) init [start - 1] = (!init [start - 1]);
        if (start != init.length - 1) init [start + 1] = (!init [start + 1]);
    }

    
    /*  
    // question number 4 faster way ********************************************
    public static boolean disco( boolean [] init, boolean [] target)
    {
        int start = 0;
        if (init.length == 1) return true; // if there is only one ball in init & target then true
        return disco(init, target, start);
    }
    
    public static boolean disco( boolean [] init, boolean [] target, int start)
    {
        if (start >= init.length - 1) // last note barrier
        {
            if (init[start] == target[start]) return true;
            else return false;
        }
        
        if (init [start] != target [start]) push(init,start + 1); // if a chang is neaded then push the next switch
        return disco(init, target, start + 1); // recoursive call next place
    }
    
    public static void push (boolean [] init, int start)
    {
        change (init, start - 1);
        change (init, start);
        if (start +1 <= init.length -1) change (init, start + 1); 
    }
    
    public static void change (boolean [] init, int start)
    {
        if (init[start] == true) init [start] = false;
        else init[start] = true;
    }    
    */
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    