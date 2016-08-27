
/**
 * extend of item, represent a CD.
 * 
 * @author (amir dror) 
 * @version (22/5/2012)
 */
public class CD extends Item 
{
    // instance variables 
    protected String _artist;
    protected int _numberOfTracks;

    /**
     * creates new CD.
     * 
     * @param title the CDs name.
     * @param year the CDs publish year.
     * @param artist the CDs artists name.
     * @param tracks the CDs number of tracks.
     */
    public CD(String title, int year, String artist, int tracks)
    {
        super (title, year);
        _artist = artist;
        _numberOfTracks = tracks;
    }
    
    /**
     * copy constructor for CDs.
     * 
     * @param  other  other CD.
     *  
     */
    public CD (CD other)
    {
        super (other._title, other._publishYear);
        _artist = other._artist;
        _numberOfTracks = other._numberOfTracks;
    }

    /**
     * returns the CDs artist.
     * 
     * @ return the CD artist.
     *  
     */
    public String getArtist()
    {
        return _artist;
    }
    
    /**
     * returns the CDs number of tracks.
     * 
     * @ return the CD number of tracks.
     *  
     */
    public int getNumberOfTracks()
    {
        return _numberOfTracks;
    }
    
    /**
     * changes the CDs artist name.
     *
     * @param artist the new artist name.
     *  
     */
    public void setArtist (String artist)
    {
        _artist = artist;
    }
    
    /**
     * changes the CDs number of tracks.
     *
     * @param tracks the new number of tracks.
     *  
     */
    public void setNumberOfTracks (int tracks)
    {
        _numberOfTracks = tracks;
    }
    
    /**
     * return a string represemtation of the CD.
     *
     * @return string represemtation of the CD.
     *  
     */
    public String toString()
    {
        return ("CD-" + _title + "\tPublished at: " + _publishYear +
                "\tby: " + _artist + "\tNumber of tracks: " + _numberOfTracks);
        
    }
    
    
    /**
     * play the CD by printing the CDs fichers.
     * 
     */
    public void play()
    {
        System.out.println ("Now playing " + _title + " by " + _artist +
                            ", enjoy listening...");
    }
}
