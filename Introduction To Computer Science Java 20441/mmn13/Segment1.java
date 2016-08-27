
/**
 * A segment1 represent a line (parallel to the x-axis) using two Points
 * 
 * @author (amir dror) 
 * @version (16.4.2012)
 */
public class Segment1
{
    // instance variables - Point _poLeft, Point _poRight.
    private Point _poLeft;
    private Point _poRight;

    /**
     * Constructs a segment. Constructs a new segment using two Points
     *
     * @param left - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment1(Point left, Point right)
    {
        _poLeft = new Point (left);
        _poRight = new Point (right);
        if (!(_poLeft.getY() == _poRight.getY()))
        {
           _poRight.setY(_poLeft.getY());     
        }
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
    public Segment1 (double leftX, double leftY,
                     double rightX, double rightY)
    {
        _poLeft = new Point (leftX,leftY);
        _poRight = new Point (rightX, rightY);
         if (!(_poLeft.getY() == _poRight.getY()))
        {
           _poRight.setY(_poLeft.getY());     
        }
    }
    
    /**
     * Copy Constructor. Construct a segment using a reference segment
     *
     * @param other - the reference segment
     * 
     */
    public Segment1 (Segment1 other)
    {
        _poLeft = new Point (other._poLeft);
        _poRight = new Point (other._poRight);
    }
        
   

    
    
    /**
     * Returns the left point of the segment 
     * 
     * 
     * @return     The left point of the segment
     */
    
    public Point getPoLeft()
    {
        return _poLeft;
    }
    
    /**
     * Returns the right point of the segment 
     * 
     * 
     * @return    The right point of the segment
     */
     public Point getPoRight()
    {
        return _poRight;
    }
    
    /**
     * Returns the segment length 
     * 
     * 
     * @return    The segment length
     */
    public double getLength()
    {
        return _poLeft.distance (_poRight);
    }
    
    /**
     * Return a string representation of this segment. i.e. (3,4)---(3,6) 
     * 
     * 
     * @return    String representation of this segment
     */
    public String toString()
    {
        return (_poLeft.toString()+"---"+_poRight.toString());
    }
    
    /**
     * Check if the reference segment is equal to this segment 
     * 
     * @param other - the reference segment 
     * @return   True if the reference segment is equal to this segment  
     */
    public boolean equals(Segment1 other)
    {
        return (_poLeft.equals(other.getPoLeft()))&&(_poRight.equals(other.getPoRight()));
    }
    
    /**
     * Check if this segment is above a reference segment 
     * 
     * @param other - the reference segment 
     * @return True if this segment is above the reference segment   
     */
    public boolean isAbove(Segment1 other)
    {
        return (_poLeft.isAbove(other.getPoLeft()))&&(_poRight.isAbove(other.getPoRight()));
    }
    
    /**
     * Check if this segment is under a reference segment. 
     * 
     * @param other - the reference segment 
     * @return True if this segment is under the reference segment     
     */
    public boolean isUnder(Segment1 other)
    {
        return (other.isAbove(this));
    }
    
    /**
     * Check if this segment is left of a received segment. 
     * 
     * @param other - the reference segment 
     * @return  True if this segment is left to the reference segment 
     */
    public boolean isLeft(Segment1 other)
    {
        return (_poRight.isLeft(other.getPoLeft()));
    }
    
    /**
     * Check if this segment is right of a received segment. 
     * 
     * @param other - the reference segment 
     * @return True if this segment is right to the reference segment    
     */
    public boolean isRight(Segment1 other)
    {
        return (_poLeft.isRight(other.getPoRight()));
    }
    
    /**
     * Move the segment horizontally by delta
     * 
     * @param delta - the displacement size
     *    
     */
    public void moveHorisontal(double delta)
    {
        _poLeft.move(delta,0);
        _poRight.move(delta,0);
    }
    
    /**
     * Move the segment vertically by delta 
     * 
     * @param delta - the displacement size
     *     
     */
    public void moveVertical(double delta)
    {
        _poLeft.move(0,delta);
        _poRight.move(0,delta);
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
        if ( _poLeft.getX() - _poRight.getX() <= delta )
        {
            _poRight.move(delta,0);
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
        return (_poLeft.getY() ==  p.getY() && _poLeft.getX() <=  p.getX() &&
                p.getX() <= _poRight.getX());
    }
    
    /**
     * Check if this segment is bigger then a reference segment 
     * 
     * @param other - the reference segment 
     * @return True if this segment is bigger than the reference segment    
     */
    public boolean isBigger (Segment1 other)
    {
        return (_poRight.getX() -  _poLeft.getX() >
                other._poRight.getX() - other._poLeft.getX());
    }
    
    /**
     * Returns the overlap size of this segment and a reference segment 
     * 
     * @param other - the reference segment 
     * @return  The overlap size   
     */
    public double overlap (Segment1 other)
    {
         double op1,op2;
        if (this.isLeft (other))
        {
            return 0;
        }
        else if (this.isRight (other))
        {
            return 0;
        }
        else if ( _poRight.getX() <= other._poRight.getX() &&
                 _poLeft.getX() >= other._poLeft.getX())
        {
            return this.getLength();             
        }
        else if ( _poRight.getX() >= other._poRight.getX() &&
                 _poLeft.getX() <= other._poLeft.getX())
        {
            return other.getLength();             
        }
        else
        {
            op1 = Math.abs( _poRight.getX() - other._poLeft.getX());
            op2 = Math.abs(_poLeft.getX() - other._poRight.getX());
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
    public double trapezePerimeter (Segment1 other)
    {
        return (_poLeft.distance(other._poLeft) + _poRight.distance(other._poRight) +
                this.getLength() + other.getLength());
    }
}
