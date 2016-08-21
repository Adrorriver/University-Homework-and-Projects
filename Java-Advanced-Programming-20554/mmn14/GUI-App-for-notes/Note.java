/**
 * class represent a note contains Date and String
 * 
 */
import java.io.Serializable;

public class Note implements Serializable {
	private Date _date;
	private String _msg;
	
	public Note (Date date, String msg){
		_date = date;
		_msg = msg;
	}
	
	public Note (Note other){
		_date = other._date;
		_msg = other._msg;
	}
	
	public Date getDate(){
		return _date;
	}
	
	public void setDate(Date date){
		_date = date;
	}
	
	public String getMsg(){
		return _msg;
	}
	
	public void setMsg(String msg){
		_msg = msg;
	}
}
