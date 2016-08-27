import java.util.ArrayList;

/**
 * Calculates all routes from top left corner of a given matrix to bottom right.
 * Route price contains the sum of all number on the route
 * 
 * @author (amir dror) 
 */ 
public class BackTracking
{   
	public static int count = 0;
	public static ArrayList<Integer> results = new ArrayList<Integer>();
	
    public static void printPathPrice(int[][]m)
    {
        printPathPrice(m,0,0,0);    
    }
    
    public static void printPathPrice(int[][]m, int r, int c, int sum)
    {
        if (r < 0 || c < 0 || r >= m.length  || c >= m[r].length|| m [r][c] == -1) return;
            
        if (r == m.length -1 && c == m[0].length -1){
        	System.out.println (sum + m[r][c]);
        	results.add(count, (sum + m[r][c])); 
        }
        else
        {
            int temp = m[r][c];
            m[r][c] = -1;
            
            printPathPrice(m,r-1,c,sum + temp);
             printPathPrice(m,r+1,c,sum + temp);
              printPathPrice(m,r,c-1,sum + temp);
               printPathPrice(m,r,c+1,sum + temp);
            m[r][c] = temp;
        }
        
    }
    
    public static int findMin(){
    	int min;
    	if (results.size() <= 0) return 0;
    	else{
    		min = results.get(0);
    		for(int e: results){
    			if(e < min) min = e;
    		}
    		return min;
    	}
    }
    
    public static void main (String [] args)
    {
        int[][] arr =  {{4,2,3,2,5}, 
                        {3,1,2,4,3},
                        {0,5,3,5,4},
                        {5,3,1,4,4},
                        {4,2,1,3,3}};
                        
        printPathPrice(arr);
        System.out.println("\nshortest route: "+findMin());
    }
}