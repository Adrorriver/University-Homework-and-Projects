
/**
 * A chess board of 5*5,
 * The program finds all possible  ways for a knight to cover the board
 * 
 * Moves defined by incrementing numbers: 1 - 25
 * 
 * @author (amir dror) 
 *
 */
public class Chess_Knight
{
   public static void go( int [][] m, int r, int c, int num )
   {
       if ( r < 0 || c <0 || r >= m.length || c >= m[r].length || m[r][c] != 0 ) return;
       
       if (num == (m.length  * m[0].length))
       {
            m[r][c] = num;
            for (int i = 0; i < m.length;i++)
            {
                for (int j =0 ; j < m[0].length; j++)
                {
                    System.out.print (m[i][j] + "\t");
                    
                }
                System.out.println(); 
            }  
            
            System.out.println();
            System.out.println("****************************************");
            System.out.println();
        }
       
       m[r][c] = num;
       go (m,r-2, c-1, num +1);
       go (m,r-2, c+1, num +1);
       go (m,r+2, c-1, num +1);
       go (m,r+2, c+1, num +1);
       go (m,r-1, c-2, num +1);
       go (m,r-1, c+2, num +1);
       go (m,r+1, c-2, num +1);
       go (m,r+1, c+2, num +1);
       
       m[r][c] = 0;
   }
   
    public static void main ( String [] args)
    {
        int[][] m = new int[5][5];
        go(m,0,0,1);
    }
}
