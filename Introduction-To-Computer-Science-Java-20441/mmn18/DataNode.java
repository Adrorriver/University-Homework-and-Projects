
/**
 *  DataNode.
 * 
 * @author (amir dror) 
 * @version (19.6.2012)
 */
public class DataNode
{
    private char _value;
    private DataNode _last;

    public DataNode (char val, DataNode last)
    {
        _value = val;
        _last = last;
    }
    
    public char getValue () {return _value;}
    
    public void setValue (char newValue) {_value = newValue;}
    
    public DataNode getLast () {return _last;}
    
    public void setLast (DataNode newLast) {_last = newLast;}
}
