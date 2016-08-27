
/**
 * This class represents a "Convex Polygon" in the plane .
 * 
 * @author (amir dror ) 
 * @version (22/4/2012)
 */
public class Polygon
{
    // instance variables 
    private Point[] _vertices;  // Point array
    int _noOfVertices;          // num of cell in use
    static final int MAX_VERTICES = 10;// max num of Point in polygon

    /**
     * Creates an empty polygon
     */
    public Polygon()
    {
        // initialise instance variables
        _vertices = new Point[MAX_VERTICES];
        _noOfVertices = 0;
    }

    
    
    
    /**
     * Adds a new Point to the Polygon with the given x and y values
     * 
     * @param  x  the specified x coordinate
     * @param  y  the specified y coordinate 
     * @return     true if the point was added successfully; false otherwise.
     */
    public boolean addVertex (int x,int y)
    {
        if (_noOfVertices <  MAX_VERTICES)
        {
            Point newPoint = new Point (x,y);
            _vertices [_noOfVertices] = newPoint;
            _noOfVertices++; // adds 1 to the _noOfVertices counter 
            return true;
        }
        else return false;
    }
    
    /**
     * Finds and returns a copy of the highest Point on the Polygon 
     * if such a point exists. If it does not exist, 
     * returns null. In the event that more than one such point exists, 
     * it returns the first point it finds.
     * 
     * 
     * @return     a Point which represents the highest vertex on the polygon 
     * if such a point exists; null otherwise.
     */
    public Point highestVertex ()
    {
        int highest = 0;
        if (_noOfVertices == 0) return null;
        for (int i = 1; i < _noOfVertices ; i++)
        {
            if (_vertices [i].isAbove(_vertices [highest])) highest = i;
        }
        return new Point (_vertices [highest]);
    }
    
    /**
     * Returns a string representation of this Polygon.
     * 
     * @return    a string representation of this Polygon.
     */
    public String toString ()
    {
        String s = ("The polygon has "+_noOfVertices+" vertices:\n("); 
        if (_noOfVertices == 0) 
            return s;
        else for (int i = 0; i < _noOfVertices - 1 ; i++) 
             {
                s = (s + _vertices[i].toString()+",");
             }
             
        s = s + _vertices [_noOfVertices - 1].toString()+")";       
        return s;
    }
    
    /**
     * Calculates and returns the perimeter of the Polygon. 
     * In the event that there are only 2 verticies, 
     * it calculates the distance of the line represented by the two verticies. 
     * In the event that there are less than 2 verticies it returns 0. 
     * 
     * @return    the perimeter of the Polygon if the Polygon has 3 or more verticies; 
     * otherwise if it has 2 verticies returns the distance between the verticies; 
     * otherwise 0.
     */
    public double calcPerimeter ()
    {
        double primeter = 0;
        if (_noOfVertices < 2) return 0;
        if (_noOfVertices > 2) 
        {
            for (int i = 1; i < _noOfVertices; i++)
            {
                primeter += _vertices[i-1].distance(_vertices[i]);
            }
        }
        primeter += _vertices[_noOfVertices-1].distance(_vertices[0]);
        return primeter;
    }
    
    /*
     * calculates The area of a triangle according to the eqetion
     * and returns it. 
     */
    
    private double Heron (Point poA,Point poB,Point poC)
    {
        Polygon triangle = new Polygon();
        triangle.addVertex ((int)poA.getX(),(int)poA.getY());
        triangle.addVertex ((int)poB.getX(),(int)poB.getY());
        triangle.addVertex ((int)poC.getX(),(int)poC.getY());
        
        double s = (triangle.calcPerimeter()/2);
        return Math.sqrt(s*(s - poA.distance(poB))*(s - poB.distance(poC))*
               (s - poC.distance(poA)));
    }
     
    /**
     * Calculates and returns the area of the Polygon. 
     * In the event that the Polygon has less than 3 verticies, it returns 0. 
     * 
     * @return     the area of the Polygon if the Polygon has 3 or more verticies;
     * otherwise 0.
     */
    public double calcArea()
    {
        double area = 0;
        for (int i =2; i < _noOfVertices ;i++)
        {
            area += this.Heron(_vertices[0], _vertices[i-1], _vertices[i]); 
        }
        return area;
    }
    
    
    /**
     * Determines whether or not the area of Polygon is bigger than 
     * the area of the instance of Polygon it is to be compared with. 
     * 
     * @param  other  an object to be compared with this Polygon 
     * @return     true if this Polygon has an area larger than 
     * the object to be compared with; false otherwise
     */
    public boolean isBigger (Polygon other)
    {
        return (this.calcArea() > other.calcArea());
    }
    
    /**
     * Finds and returns the index of a vertex. 
     * 
     * @param  p  the Point whose index will be returned 
     * @return     the index of p if the Point exists in the Polygon; otherwise-1
     */
    public int findVertex (Point p)
    {
        int cell = -1;
        for (int i = 0; i <_noOfVertices; i++)
        {
            if (p.equals(_vertices[i])) cell = i;   
        }
        return cell;
    }
    
    /**
     *Finds and returns a copy of the successor of a Point in the Polygon.
     * 
     * @param  p  the Point whose successor will be returned 
     * @return    the successor of p if Point exists in the Polygon; otherwise null
     */
    public Point getNextVertex (Point p)
    {
        int i;
        i = this.findVertex(p);
        if (i == -1 ) return null;
        else if (_noOfVertices == 1) return new Point(_vertices[i]);
        else if (i ==_noOfVertices - 1 ) return new Point (_vertices[0]);
        else return new Point (_vertices[i+1]);
    }
    
    /**
     *Calculates and returns a Polygon which represents the bounding box
     *of this Polygon.
     *The bounding box is the smallest Rectangle whose sides are
     *parallel to the x and y axes of the coordinate space, 
     *and can completely contain the Polygon. 
     * 
     *  
     * @return   a Polygon (in the shape of a rectangle) 
     * that defines the bounds of this Polygon
     */
    public Polygon getBoundingBox ()
    {
        Polygon rectangle;
        Point high;
        Point low;
        Point left;
        Point right;
        if (_noOfVertices < 3) return null;
        else 
        { 
            rectangle= new Polygon();
            high = new Point (this.highestVertex());
            low = new Point (this.lowestVertex());
            left = new Point (this.leftestVertex());
            right = new Point (this.rightestVertex());
            
            rectangle.addVertex((int)left.getX(),(int)low.getY());
            rectangle.addVertex((int)right.getX(),(int)low.getY());
            rectangle.addVertex((int)right.getX(),(int)high.getY());
            rectangle.addVertex((int)left.getX(),(int)high.getY());
            return rectangle;
        }
    }
    
    /*
     * Finds and returns a copy of the lowest Point on the Polygon 
     * if such a point exists. If it does not exist, 
     * returns null. In the event that more than one such point exists, 
     * it returns the first point it finds.
     * 
     * 
     * @return     a Point which represents the lowest vertex on the polygon 
     * if such a point exists; null otherwise.
     */
    private Point lowestVertex ()
    {
        int lowest = 0;
        for (int i = 1; i < _noOfVertices ; i++)
        {
            if (_vertices [i].isUnder(_vertices [lowest])) lowest = i;
        }
        return new Point (_vertices [lowest]);
    }
    
    /*
     * Finds and returns a copy of the leftest Point on the Polygon 
     * if such a point exists. If it does not exist, 
     * returns null. In the event that more than one such point exists, 
     * it returns the first point it finds.
     * 
     * 
     * @return     a Point which represents the leftest vertex on the polygon 
     * if such a point exists; null otherwise.
     */
    private Point leftestVertex ()
    {
        int leftest = 0;
        for (int i = 1; i < _noOfVertices ; i++)
        {
            if (_vertices [i].isLeft(_vertices [leftest])) leftest = i;
        }
        return new Point (_vertices [leftest]);
    }
    
    /*
     * Finds and returns a copy of the rightest Point on the Polygon 
     * if such a point exists. If it does not exist, 
     * returns null. In the event that more than one such point exists, 
     * it returns the first point it finds.
     * 
     * 
     * @return     a Point which represents the rightest vertex on the polygon 
     * if such a point exists; null otherwise.
     */
    private Point rightestVertex ()
    {
        int rightest = 0;
        for (int i = 1; i < _noOfVertices ; i++)
        {
            if (_vertices [i].isRight(_vertices [rightest])) rightest = i;
        }
        return new Point (_vertices [rightest]);
    }
}
