
/**
 * extend of item, represent a video.
 * 
 * @author (amir dror) 
 * @version (22/5/2012)
 */
public class Video extends Item
{
    // instance variables 
    protected String _director;

    /**
     * creates new  Video
     * 
     * @param title the videos name.
     * @param year the videos publish year.
     * @param director the videos director.
     */
    public Video(String title, int year, String director)
    {
        super (title, year);
       _director = director;
    }

    /**
     * copy constructor for videos.
     * 
     * @param  other other video.
     *  
     */
    public Video (Video other)
    {
        super (other._title, other._publishYear);
        _director = other._director;
    }
    
    /**
     * returns the video director.
     * 
     * 
     * @return     the video director. 
     */
    public String getDirector ()
    {
        return _director;
    }
    
    /**
     * changes the the video director.
     * 
     * 
     * @param director the video new director. 
     */
    public void setDirector (String director)
    {
        _director = director;
    }
    
    /**
     * returns a string representation of the video.
     * 
     * 
     * @return    string representation of the video. 
     */
    public String toString ()
    
    {
        return ("Video-" + _title + "\tPublished at: " + _publishYear +
                "\tdirected by: " + _director);
    }
    
    
    /**
     * play the video by printing the videos fichers.
     * 
     */
    public void play ()
    {
        System.out.println("Now palying " + _title + " directed by " +
                            _director + ", enjoy watching...");
    }
    
    /**
     * determines if this video is older then a sertun year.
     * 
     * @param year the year being tested.
     * @return true if the video is older fals otherwise.
     */
    public boolean isOlder (int year)
    {
        return (_publishYear < year);
    }
}
