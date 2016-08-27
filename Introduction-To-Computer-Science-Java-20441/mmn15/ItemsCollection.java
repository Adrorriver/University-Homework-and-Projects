
/**
 *  Collection of items: CDs and videos.
 * 
 * @author (amir dror) 
 * @version (22/5/2012)
 */
public class ItemsCollection
{
    // instance variables 
    private Item[] _list;
    private final int MAXITEMS = 20;
    private int _numItems;
    
    /**
     * creates an empty item collection.
     */
    public ItemsCollection()
    {
        // initialise instance variables
        _list = new Item[MAXITEMS];
        _numItems = 0;
    }

    /**
     * adds an item to the item collection if the new item is not empty,
     * and if there is an empty place in the collection.
     * 
     * @param  newItem  tne new item adds to the collection.
     * @return  true if the item adds successfully, fals otherwise.
     */
    public boolean addItem (Item newItem)
    {
        if (newItem == null) return false;
        if (_numItems < MAXITEMS)
        {
            _list[_numItems] = newItem; 
            _numItems++;
            return true;
        }
        else return false;
    }
    
     /**
     * play item by printing the items fichers
     * 
     * 
     * @param  itemNumber  the number of the item to play (0-19).
     * 
     */
    public void playItem (int itemNumber)
    {
        if (0 <= itemNumber && itemNumber < _numItems)
        {
            _list [itemNumber].play();
        }
        else System.out.println ("item no " + itemNumber + " doesn't"+ 
             " exist in the collection.");
    }
    
     /**
     * chacks and return how many CDs are in the collection.
     *  
     * @return the number of CDs i the collection.
     * 
     */
    public int getNumberOfCDs()
    {
        int count = 0;
        for (int i = 0; i < _numItems; i++)
        {
            if (_list[i] instanceof CD ) count ++;
        }
        return count;
    }
    
     /**
     * chacks if a video is older then a given year.
     * if true print a string representation of the video.
     * 
     * 
     * @param  year  the year to be tested.
     * 
     */
    public void oldiesButGoldies (int year)
    {
      for (int i = 0; i < _numItems; i++)
        {
            if (_list[i] instanceof Video ) 
            {
                if(((Video)_list[i]).isOlder (year)) System.out.println ((Video)_list[i]);
            }
        }  
    }
    
     /**
     * return a string representation of the item collection.
     * 
     * 
     * @return string representation of the item collection.
     * 
     */
    public String toString ()
    {
        String s = "the items in the collection are:\n";
        for (int i = 0; i < _numItems; i++)
        {
            s += _list[i].toString() + "\n";
        }
        return s;
    }
}
