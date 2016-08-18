
/**
 *  DataStack.
 * 
 * @author (amir dror) 
 * @version (19.06.2012)
 */
public class DataStack
{
   private DataNode _head;
   
   public boolean empty () {return (_head == null);}
   
   public void push (DataNode node)
   {
       node.setLast (_head);
       _head = node; 
   }
   
   public DataNode pop ()
   {
       if (empty()) return null;
       else 
       {
           DataNode temp = _head;
           _head = _head.getLast();
           return temp;
       }
   }
   
   public void remove () {_head = null;}
}
