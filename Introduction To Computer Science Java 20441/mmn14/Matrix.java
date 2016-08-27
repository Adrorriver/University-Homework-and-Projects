
/**
 * This class represents a two dimensional Matrix
 * 
 * @author (amir dror ) 
 * @version (24/4/2012)
 */
public class Matrix
{
    
    private int[][] _array;// instance variables - array of array of int
    private final int white = 0;
    private final int black = 255;
    
    /**
     * Constructs a Matrix from a two-dimensional array; the dimensions
     * as well as the values of this Matrix will be the same as the 
     * dimensions and values of the two-dimensional array.
     * 
     * @param array  a two dimensional array. It is the source of the initial values for Matrix
     */
    public Matrix(int [][] array)
    {
        // copy Constructor
        _array = new int [array.length][]; 
        
        for (int i = 0; i < array.length; i++)
            {
                _array [i] = new int [array [i].length];
                for (int j = 0; j < array [i].length; j++)
                {
                    if ( white <= array [i][j] && array [i][j] <= black)
                        {
                         _array [i][j] = array [i][j];
                        }
                    else _array [i][j] = 0;
                }
            }
    }

    /**
     * Constructs a size1 by size2 Matrix of zeroes.
     * 
     * @param size1  number of rows in the Matrix
     * @param size2  number of columns in the Matrix
     */
    public Matrix (int size1, int size2)  
    {
        _array = new int [size1][size2];
    }
    
    
    /**
     * Returns a string representation of this Matrix. All numbers appearing in the same 
     * row are separated by the tab key; all rows are separated by the '\n' char. 
     * 
     * 
     * @return   a string representation of this Matrix
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < _array.length; i++)
        {
            for (int j = 0; j < _array[i].length; j++)
            {
                s += _array[i][j];
                if (j != _array[i].length - 1)
                {
                    s += "\t";
                }
            }
            s += "\n";
        }
        return s;   
    }
    
    /**
     * Calculates and returns a negative copy of this Matrix. All pixels 
     * are represented by a number 0-255 inclusive.
     * 
     * 
     * @return     a negative copy of this Matrix
     */
    public Matrix makeNegative ()
    {
        Matrix negative = new Matrix (_array);
        for (int i = 0; i < negative._array.length; i++)
        {
            for (int j = 0; j < negative._array[i].length; j++)
            {
                negative._array[i][j] = 255 - _array[i][j];
            }
        }
        return negative;
    }
    
    /**
     * Calculates and returns a copy of this Matrix after it has been filtered from noise. 
     * All pixels are represented by a number 0-255 inclusive. 
     * 
     * 
     * @return    a copy of this Matrix after it has been filtered from noise
     */
    public Matrix imageFilterAverage()
    {
        Matrix filter = new Matrix (_array);
        for (int i = 0; i < this._array.length; i++)
        {
            for (int j = 0; j < this._array[i].length; j++)
            {
                filter._array [i][j] = this.average (i,j);
            }
        }
        return filter;  
    }
    
     /*
     * calculates the average of the near by  cells
     * return  the average 
     * 
     *  
     */
    private int average (int row, int col)
    {
        int sum = 0;
        int count = 0;
        for (int i = row -1 ; i <= row+1; i++)
        {
            if ((i != -1) && (i != this._array.length ) ) 
            {
                for (int j = col -1 ; j <= col + 1; j++)
                {
                    if ((j != -1) && (j != this._array[i].length ) ) 
                    {
                        sum += this._array[i][j];
                        count ++;
                    }
                }
            }
        }
        return (sum / count);
    }
    
    
    /*
     * calculates the average of the near by  cells
     * return  the average 
     * 
     *  
     *
    private int average (int row, int col)
    {
        int sum = 0;
        int count = 0;
        for (int i = row -1 ; i <= row+1; i++)
        {
            if ((i == -1) || (i == this._array.length ) ) continue;
            else
            {
                for (int j = col -1 ; j <= col + 1; j++)
                {
                    if ((j == -1)|| (j == this._array[i].length ) ) continue;
                    else 
                    {
                        sum += this._array[i][j];
                        count ++;
                    }
                }
            }
        }
        return (sum / count);
    }
    
    */
    
    
    /*
     * another way of implamenting imageFilterAverage
     * 
    private int average (int row, int col)
    {
        int ave = 0;
        if ((row != 0) && (row != this._array.length - 1 ))    
        {
            ave += this.calcrow (row -1, col);
            ave += this.calcrow (row , col);
            ave += this.calcrow (row +1, col);
            ave = ave/3;
        }
        else if (row == 0 ) 
        {
            ave += this.calcrow (row, col);
            ave += this.calcrow (row + 1, col);
            ave = ave/2;
        }
        
        else if (row == this._array.length - 1 ) 
        {
            ave += this.calcrow (row -1, col);
            ave += this.calcrow (row , col);
            ave = ave/2;
        }
        return ave;
    }
    
    private int calcrow (int row, int col)
    {
        int ave = 0;
        if ((col != 0) && (col != this._array[row].length - 1))
            ave = (this._array[row][col - 1] + this._array[row][col]+
                    this._array[row][col + 1])/3;
        else if (col == 0 ) 
            ave = (this._array[row][col] + this._array[row][col + 1])/2;
        
        else if (col == this._array[row].length - 1 ) 
            ave = (this._array[row][col - 1] + this._array[row][col])/2;
        return ave;
    }*/
}
