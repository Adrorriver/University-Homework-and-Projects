
/**
 * Abstract class Item - represent basic item
 * 
 * @author (amir dror)
 * @version (9/5/2012)
 */
public abstract class Item
{
    // instance variables 
    protected String _title; // item name       
    protected int _publishYear; 
    
    /**
     * Creates new item
     * 
     * @param title    items name
     * @param year items publish year. 
     */ 
    public Item(String title, int year)
    {
        _title = title;
        _publishYear = year;
    }

    /**
     * copy constructor for items
     * 
     * @param  oter item
     *  
     */
    public Item(Item other)
    {
        _title = other._title;
        _publishYear =other._publishYear;  
    }
    
    /**
     * returns the item title.
     * 
     * 
     * @return     the item title. 
     */
    public String getTitle()
    {
        return _title;
    }
    
    /**
     * returns the item publish year.
     * 
     * 
     * @return     the item publish yaer. 
     */
    public int getPublishYear()
    {
        return _publishYear;
    }
    
    /**
     *changes the item title.
     * 
     * 
     * @param  newTitle the new title of the item. 
     */
    public void setTitle (String newTitle)
    {
        _title = newTitle;
    }
    
    /**
     * changes the item publish year.
     * 
     * 
     * @param newYear the new pulish year of the item.    
     */
    public void setPublishYear (int newYear)
    {
        _publishYear = newYear;
    }
    
    /**
     * returns a string representation of this item.
     * 
     * 
     * @return string representation of this item. 
     */
    public String toString ()
    {
        return (_title + "\t Published at: " + _publishYear);

    }
    
    /**
     * abstract method each item plays diffrent.  
     */
    public abstract void play();
}
