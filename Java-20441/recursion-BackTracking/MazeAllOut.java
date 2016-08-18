
/**
 * The program find a way out of the maze, by checking all the possible options.
 * 
 * start at (1,1)
 * 
 * maze wall:  #
 * open space: -
 * program track: t 
 * 
 * @author (amir dror) 
 */
public class MazeAllOut
{
    public static void maze (char [][] m, int r, int c)
    {
        if (r < 0 || c < 0 || r >= m.length || c >= m[r].length || m[r][c] == '#' || m[r][c] == 't') return;
        
        if (r == 0 || c == 0 || r == m.length -1 || c == m[r].length -1)
        {
            m[r][c] = 't';
            for (int i = 0; i < m.length; i++)
            {
                for(int j = 0; j < m[r].length; j++)
                {
                    System.out.print (m[i][j] +"\t");
                   
                } 
                 System.out.println();
            }
             System.out.println();
              System.out.println();
               System.out.println();
            
        }
        
        m[r][c] = 't';
        maze (m,r-1,c);
        maze (m,r+1,c);
        maze (m,r,c-1);
        maze (m,r,c+1);
        m[r][c] = '-';
        
    }
    
    public static void main ( String [] args)
    {
        char [][] m = { {'#','#','#','#','#','#','#','#','#','#','#','#'},
                        {'#','-','-','#','#','#','#','#','-','#','-','#'},
                        {'#','#','-','#','#','#','#','#','-','-','-','#'},
                        {'#','#','-','#','#','#','#','#','-','#','-','#'},
                        {'#','#','-','-','-','-','#','#','-','#','-','#'},
                        {'#','#','-','#','#','-','-','-','-','#','-','#'},
                        {'#','#','-','#','-','-','#','#','-','#','-','#'},
                        {'#','#','-','#','-','-','#','#','-','#','-','#'},
                        {'#','#','-','#','#','-','#','#','-','#','-','#'},
                        {'#','#','#','#','#','#','#','#','#','#','-','#'}};
        maze( m, 1,1);
        
    }
    
}