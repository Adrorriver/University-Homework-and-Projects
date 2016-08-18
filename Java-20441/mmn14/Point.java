
/**
 * Represents 2 dimensional integral points on a map.
 * 
 * @author (amir dror) 
 * @version (15.4.2012)
 */
public class Point
{
    // instance variables- double _x, double _y.
    private double _x;
    private double _y;
    
    /**
     * Constructs a point.
     */
    public Point(double x, double y)
    {
        // initialise instance variables
        _x = x;
        _y = y;
    }
    
    /**
     *  Copy constructor for Points.
     */
    
    public Point (Point other)
    {
        _x = other._x;
        _y = other._y;
    }

    /**
     * Returns the x coordinate of the point. 
     * 
     * 
     * @return    The x coordiante of the point
     */
    public double getX()
    {
        // put your code here
        return _x;
    }
    
    /**
     * Returns the y coordinate of the point. 
     * 
     *
     * @return    The y coordinate of the point
     */
    public double getY()
    {
        return _y;
    }
    
    /**
     *  Changes the x coordinate of the point.
     * 
     * @param  num   The new x coordinate
     *
     */
    public void setX (double num)
    {
        _x = num;
    }
    
    /**
     * Changes the y coordinate of the point. 
     * 
     * @param num   The new y coordinate
     * 
     */
    public void setY (double num)
    {
        _y = num;
    }
    
    /**
     * Return a string representation of this point. i.e. (3,4) 
     * 
     * 
     * @return   String representation of this point
     */
    public String toString()
    {
        return ("(" +_x+","+_y+")");
    }
    
    /**
     * Check if the received point is equal to this point.  
     * 
     * @param  other   The point to be compared with this point 
     * @return    True if the received point is equal to this point
     */
    public boolean equals (Point other)
    {
        return ((_x == other.getX()) && (_y == other.getY()));
    }
    
    /**
     * Check if this point is above a received point.
     * 
     * @param  other  The point to check if this point is above
     * @return   True if this point is above other point
     */
    public boolean isAbove (Point other)
    {
        return (_y > other.getY());
    }
    
    /**
     * Check if this point is below a received point.  
     * 
     * @param  other  The point to check if this point is below
     * @return    True if this point is below other point
     */
    public boolean isUnder (Point other)
    {
        return (other.isAbove(this));
    }
    
    /**
     * Check if this point is left of a received point. 
     * 
     * @param  other  The point to check if this point is left of 
     * @return    True if this point is left of other point
     */
    public boolean isLeft (Point other)
    {
        return (_x < other.getX());
    }
    
    /**
     * Check if this point is right of a received point. 
     * 
     * @param  other  The point to check if this point is right of 
     * @return    True if this point is right of other point
     */
    public boolean isRight (Point other)
    {
        return (other.isLeft(this));
    }
    
    /**
     * Check the distance between this point and a received point. 
     * 
     * @param  p  The point to check distance from 
     * @return    double representing the distance
     */
    public double distance (Point p)
    {
        return (Math. sqrt((Math.pow((p.getY()-_y),2))+(Math.pow(p.getX()-_x,2))));
    }
   
    /**
     * Move the x coordinate by dX and the y coordinate by dY. 
     * 
     * @param dX - The amount to move x
     * @param dY - The amount to move y
     * 
     */
    public void move (double dx, double dy)
    {
        _x = (_x + dx);
        _y = (_y + dy);
    }
            
    
}
