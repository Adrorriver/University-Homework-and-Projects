
/**
 * holds a group of positive odd numbers.
 * 
 * @author (amir dror) 
 * @version (17.06.2012)
 */
public class Set
{
    private IntNode _head;
    private IntNode _last;
    private int _length;

    public boolean isEmpty()
    {
        return(_head == null);
    }
    // time O(1), place O(1)
    
         
    public boolean isMember (int num)
    {
        IntNode cur = _head;
        while (cur != null && cur.getValue() <= num)
        {
            if (num == cur.getValue()) return true;
            cur = cur.getNext();
        }
        return false;
    }
    // time O(n), place O(1)
    
    
    public boolean equals (Set other)
    {
        IntNode cur = _head;
        IntNode oCur = other._head;
        if (cur == null && oCur == null) return true;
        if (cur == null && oCur != null) return false;
        if (cur != null && oCur == null) return false;
        
        while (cur.getValue() == oCur.getValue())
        {
            cur = cur.getNext();
            oCur = oCur.getNext();
            if (cur == null && oCur == null) return true;
            if (cur == null && oCur != null) return false;
            if (cur != null && oCur == null) return false;
        }
        return false;
    }
    // time O(n), place O(1)
    
    
    public int numOfElements()
    {
        return _length;
    }
    // time O(1), place O(1)
    
    
    public boolean subSet (Set other)
    {
        IntNode cur = _head;
        IntNode oCur = other._head;
        if (cur == null && oCur != null) return false;
        if (cur == null && oCur == null) return true;
        
        while (oCur != null)
        {
            if (cur.getValue() < oCur.getValue()) cur = cur.getNext();
            else if (cur.getValue() != oCur.getValue()) return false;
            else oCur = oCur.getNext();
        }
        return true;
    }
     // time O(n), place O(1)
    
    /* // less efficient
      public boolean subSet (Set other)
    {
        IntNode cur = other._head;
        while ( cur != null)
        {
            if (!isMember(cur.getValue())) return false ;
            cur = cur.getNext();
        }
        return true;
    }
     // time O(n^2), place O(1) */
    
    
     
     
      
    public void addToSet (int x)
    {
        IntNode cur = _head;
        IntNode prev = null; 
        if (cur == null && (x%2 != 0) && (x > 0)) // for empty list
        {
            _head = new IntNode (x,null);
            _last = _head;
            _length += 1;
        }
        else if (!isMember(x) && (x%2 != 0) && (x > 0)) // chek for doubles, even, and negitive   
        {
           while (cur != null && cur.getValue() < x)
           {
                prev = cur;
                cur = cur.getNext();
           }
           
           if (prev == null)  // before the list
           {
               _head = new IntNode (x,cur);
               _length += 1;
           }
           else if (cur == null) //  after the list
           {
               cur = new IntNode (x,null);
               prev.setNext (cur);
               _last = cur;
               _length += 1;     
           }
           else // inside the list 
           {
               cur = new IntNode (x,cur);
               prev.setNext (cur);
               _length += 1; 
           }
        }
    }
    // time O(n), place O(1)
    
    
    
    public String toString()
    {
        String str = "{";
        IntNode cur = _head;
        while (cur != null)
        {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null) str += ",";
        }
        return str += "}";    
    }
    // time O(n), place O(n)     
    
    
    public void removeFromSet (int x)
    {
        IntNode cur = _head;
        IntNode prev = null; 
        if (cur == null); // for empty list
        else if (isMember(x)) // chek that the number is in the list  
        {
           while (cur != null && cur.getValue() < x)
           {
                prev = cur;
                cur = cur.getNext();
           }
           
           if (prev == null)  // first in the list
           {
               _head = cur.getNext();
               _length -= 1;
           }
           else if (cur.getNext() == null) //  last in the list
           {
               prev.setNext (null);
               _last = prev;
               _length -= 1; 
           }
           else // inside the list
           {
               prev.setNext (cur.getNext()); 
               _length -= 1; 
           }
        }
    }
    // time O(n), place O(1)
    
    
    private void addNext (int x) // private only for the next 3 methode runs at O(1)
    {
        if (_head == null && (x%2 != 0) && (x > 0)) // for empty list
        {
            _head = new IntNode (x,null);
            _last = _head;
            _length += 1;
        }
        else if (!isMember(x) && (x%2 != 0) && (x > 0)) // chek for doubles, even, and negitive   
        {
           _last.setNext(new IntNode (x,null));
           _last = _last.getNext(); 
           _length += 1; 
        }
    }
    // time O(1), place O(1)
    
    
    public Set intersection (Set other)
    {
        Set result = new Set(); 
        IntNode cur = _head;
        IntNode oCur = other._head;
        while (cur != null && oCur != null)
        {
            if (cur.getValue() == oCur.getValue())
            {
                result.addNext(cur.getValue());
                cur = cur.getNext(); 
                oCur = oCur.getNext();
            }
            else if (cur.getValue() > oCur.getValue())oCur = oCur.getNext();
            else cur = cur.getNext();      
        }
        return result;
    } 
    // time O(n), place O(n)
    
    /* // less efficient 
    public Set intersection (Set other)
    {
        Set result = new Set(); 
        IntNode cur = _head;
        while (cur != null)
        {
            if (other.isMember(cur.getValue())) result.addToSet(cur.getValue());        
            cur = cur.getNext();
        }
        return result;
    } 
    // time O(n^2), place O(n) */
    
    
    
    
    public Set union (Set other)
    {
       Set result = new Set(); 
       IntNode cur = _head;
       IntNode oCur = other._head;
       while (cur != null && oCur != null)
       {
            if (cur.getValue() == oCur.getValue())
            {
                result.addNext(cur.getValue());
                cur = cur.getNext(); 
                oCur = oCur.getNext();
            }
            else if (cur.getValue() > oCur.getValue())
            {
                result.addNext(oCur.getValue());
                oCur = oCur.getNext();
            }
            else
            {
                result.addNext(cur.getValue());
                cur = cur.getNext();
            }
       }
       
       while (cur != null)
       {
            result.addNext(cur.getValue());
            cur = cur.getNext();     
       }
       
       while (oCur != null)
       {
            result.addNext(oCur.getValue());
            oCur = oCur.getNext();     
       }
       return result;
    } 
    // time O(n), place O(n)
    
    /* // less efficient
    public Set union (Set other)
    {
        Set result = new Set(); 
        IntNode cur = _head;
        while (cur != null)
        {
            result.addToSet(cur.getValue());        
            cur = cur.getNext();
        }
        cur = other._head;
        while (cur != null)
        {
            result.addToSet(cur.getValue());        
            cur = cur.getNext();
        }
        return result;
    } 
    // time O(n^2), place O(n) */
    
    
    public Set difference (Set other)
    {
       Set result = new Set(); 
       IntNode cur = _head;
       IntNode oCur = other._head;
       while (cur != null && oCur != null)
       {
            if (cur.getValue() == oCur.getValue())
            {
                cur = cur.getNext(); 
                oCur = oCur.getNext();
            }
            else if (cur.getValue() > oCur.getValue()) oCur = oCur.getNext();
            
            else
            {
                result.addNext(cur.getValue());
                cur = cur.getNext();
            }
       }
       
       while (cur != null)
       {
            result.addNext(cur.getValue());
            cur = cur.getNext();     
       }
       return result;
    }
    // time O(n), place O(n)
    
    
    
    
    /* // less efficient
    public Set difference (Set other)
    {
        Set result = new Set();
        result = this.union(result);
        IntNode cur = other._head;
        while (cur != null)
        {
            result.removeFromSet(cur.getValue());
            cur = cur.getNext();
        }
        return result;
    }
    // time O(n^2), place O(n) */
    
      
          
    
}    
