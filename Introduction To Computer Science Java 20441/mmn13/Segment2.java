
/**
 * A segment2 represent a line (parallel to the x-axis) using a center point and length 
 * 
 * @author (amir dror) 
 * @version (17.4.2012)
 */
public class Segment2
{
    // instance variables - Point _poCenter ,double _length.
    private Point _poCenter;
    private double _length;

    /**
     * Constructs a segment. Constructs a new segment using a center point and the segment length
     *
     * @param poCenter - the Center Point
     * @param length - the segment length
     */
    public Segment2(Point poCenter, double length)
    {
        _length = length;
        _poCenter = new Point (poCenter);
    }
    
    /**
     * Constructs a segment. Constructs a new segment using two Points
     *
     * @param left - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment2(Point left, Point right)
    {
        Point poLeft, poRight;
        poLeft = new Point (left);
        poRight = new Point (right);
        if (!(poLeft.getY() == poRight.getY()))
        {
           poRight.setY(poLeft.getY());     
        }
        _length = poLeft.distance (poRight);
        _poCenter = new Point ((poLeft.getX() + poRight.getX())/2
        ,poLeft.getY());
    }
    
    /**
     * Constructs a segment. Constructs a new segment using 4 specified x y coordinates: 
     * two coordinates for the left point and two coordinates for the right point
     *
     * @param leftX - X value of left point
     * @param leftY - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment2 (double leftX, double leftY,
                     double rightX, double rightY)
    {
        Point poLeft,poRight;
        poLeft = new Point (leftX,leftY);
        poRight = new Point (rightX, rightY);
         if (!(poLeft.getY() == poRight.getY()))
        {
           poRight.setY(poLeft.getY());     
        }
        _length = poLeft.distance (poRight);
        _poCenter = new Point ((poLeft.getX() + poRight.getX())/2
        ,poLeft.getY());
    }
    
    /**
     * Copy Constructor. Construct a segment using a reference segment
     *
     * @param other - the reference segment
     * 
     */
    public Segment2 (Segment2 other)
    {
        _poCenter = new Point (other._poCenter);
        _length =  other._length;
    }
        
   

    
    
    /**
     * Returns the left point of the segment 
     * 
     * 
     * @return     The left point of the segment
     */
    
    public Point getPoLeft()
    {
        return new Point(_poCenter.getX() - _length/2, _poCenter.getY());
    }
    
    /**
     * Returns the right point of the segment 
     * 
     * 
     * @return    The right point of the segment
     */
     public Point getPoRight()
    {
        return new Point(_poCenter.getX() + _length/2, _poCenter.getY());
    }
    
    /**
     * Returns the segment length 
     * 
     * 
     * @return    The segment length
     */
    public double getLength()
    {
        return _length;
    }
    
    /**
     * Return a string representation of this segment. i.e. (3,4)---(3,6) 
     * 
     * 
     * @return    String representation of this segment
     */
    public String toString()
    {
        Point poLeft = new Point(_poCenter.getX() - _length/2, _poCenter.getY());
        Point poRight = new Point(_poCenter.getX() + _length/2, _poCenter.getY());
        return (poLeft.toString()+"---"+poRight.toString());
    }
    
    /**
     * Check if the reference segment is equal to this segment 
     * 
     * @param other - the reference segment 
     * @return   True if the reference segment is equal to this segment  
     */
    public boolean equals(Segment2 other)
    {
        return (_poCenter.equals(other._poCenter)&& _length == other._length);
    }
    
    /**
     * Check if this segment is above a reference segment 
     * 
     * @param other - the reference segment 
     * @return True if this segment is above the reference segment   
     */
    public boolean isAbove(Segment2 other)
    {
        return (_poCenter.isAbove(other._poCenter));
    }
    
    /**
     * Check if this segment is under a reference segment. 
     * 
     * @param other - the reference segment 
     * @return True if this segment is under the reference segment     
     */
    public boolean isUnder(Segment2 other)
    {
        return (other.isAbove(this));
    }
    
    /**
     * Check if this segment is left of a received segment. 
     * 
     * @param other - the reference segment 
     * @return  True if this segment is left to the reference segment 
     */
    public boolean isLeft(Segment2 other)
    {
        Point otherPoLeft = new Point(other._poCenter.getX() - other._length/2, other._poCenter.getY());
        Point poRight = new Point(_poCenter.getX() + _length/2, _poCenter.getY());
        return (poRight.isLeft(otherPoLeft));
    }
    
    /**
     * Check if this segment is right of a received segment. 
     * 
     * @param other - the reference segment 
     * @return True if this segment is right to the reference segment    
     */
    public boolean isRight(Segment2 other)
    {
        Point poLeft = new Point(_poCenter.getX() - _length/2, _poCenter.getY());
        Point otherPoRight = new Point(other._poCenter.getX() + other._length/2,other._poCenter.getY());
        return (poLeft.isRight(otherPoRight));
    }
    
    /**
     * Move the segment horizontally by delta
     * 
     * @param delta - the displacement size
     *    
     */
    public void moveHorisontal(double delta)
    {
        _poCenter.move(delta,0);
    }
    
    /**
     * Move the segment vertically by delta 
     * 
     * @param delta - the displacement size
     *     
     */
    public void moveVertical(double delta)
    {
        _poCenter.move(0,delta);
    }
    
    /**
     * Change the segment size by moving the right point by delta Will be done only for valid delta:
     * only if the new right point remains the right point 
     * 
     * @param delta - the change size
     *      
     */
    public void changeSize(double delta)
    {
        if ( -_length <= delta )
        {
            _poCenter.move(delta/2 , 0);
            _length = _length + delta;
        }
    }
    
    /**
     * Check if a point is located on the segment 
     * 
     * @param p - a point to be checked 
     * @return True if p is on this segment    
     */
    public boolean pointOnSegment(Point p)
    { 
        return (_poCenter.getY() ==  p.getY() && 
                _poCenter.getX()- _length/2 <=  p.getX() &&
                p.getX() <= _poCenter.getX()+ _length/2);
    }
    
    /**
     * Check if this segment is bigger then a reference segment 
     * 
     * @param other - the reference segment 
     * @return True if this segment is bigger than the reference segment    
     */
    public boolean isBigger (Segment2 other)
    {
        return (_length > other._length);
    }
    
    /**
     * Returns the overlap size of this segment and a reference segment 
     * 
     * @param other - the reference segment 
     * @return  The overlap size   
     */
    public double overlap (Segment2 other)
    {
        double op1,op2;
        Point poLeft = new Point(_poCenter.getX() - _length/2, _poCenter.getY());
        Point poRight = new Point(_poCenter.getX() + _length/2, _poCenter.getY());
        Point otherPoLeft = new Point(other._poCenter.getX() - other._length/2,other._poCenter.getY());
        Point otherPoRight = new Point(other._poCenter.getX() + other._length/2,other._poCenter.getY());
         if (this.isLeft (other))
        {
            return 0;
        }
        else if (this.isRight (other))
        {
            return 0;
        }
        else if ( poRight.getX() <= otherPoRight.getX() &&
                  poLeft.getX() >= otherPoLeft.getX())
        {
            return this.getLength();             
        }
        else if ( poRight.getX() >= otherPoRight.getX() &&
                 poLeft.getX() <= otherPoLeft.getX())
        {
            return other.getLength();             
        }
        else
        {
            op1 = Math.abs( poRight.getX() - otherPoLeft.getX());
            op2 = Math.abs( poLeft.getX() - otherPoRight.getX());
            if (op1 <= op2) 
            {
                return op1;
            }
            else return op2;
        }
    }
    
    /**
     * Compute the trapez perimeter, which constructed by this segment and a reference segment
     * 
     * @param other - the reference segment 
     * @return  The trapez perimeter   
     */
    public double trapezePerimeter (Segment2 other)
    {
        Point poLeft = new Point(_poCenter.getX() - _length/2, _poCenter.getY());
        Point poRight = new Point(_poCenter.getX() + _length/2, _poCenter.getY());
        Point otherPoLeft = new Point(other._poCenter.getX() - other._length/2,other._poCenter.getY());
        Point otherPoRight = new Point(other._poCenter.getX() + other._length/2,other._poCenter.getY());
        return (poLeft.distance(otherPoLeft) + poRight.distance(otherPoRight) +
                this.getLength() + other.getLength());
    }
}
