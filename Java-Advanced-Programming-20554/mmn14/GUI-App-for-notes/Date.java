/**
 * class represent a Date contains day, month, year 
 * warning Do not check for illegal dates like: 31.2 or 31.4 
 */
import java.io.Serializable;

public class Date implements Serializable {
	
	private int day;
	private int month;
	private int year;
	
	private final int DEFAULT_NUM = 1;
	private final int MIN_DAY_MONTH = 1;
	private final int MAX_DAY = 31;
	private final int MAX_MONTH = 12;
	private final int MAX_YEAR = 2100;
	private final int MIN_YEAR = 2000;
	private final int PRIME = 31;

	public Date(Date other){
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}
	
	public Date(int day, int month, int year) {
		 
		if (day < MIN_DAY_MONTH || day > MAX_DAY) {
			this.day = DEFAULT_NUM;
		} else {
			this.day = day;
		}
		if (month < MIN_DAY_MONTH || month > MAX_MONTH) {
			this.month = DEFAULT_NUM;
		} else {
			this.month = month;
		}
		if (year < MIN_YEAR || year > MAX_YEAR) {
			this.year = MIN_YEAR;
		} else {
			this.year = year;
		}
	}
	

	@Override
	public int hashCode() {
		int result = 1;
		result = PRIME * result + day;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Date)) {
			return false;
		}
		Date other = (Date) obj;
		if (day != other.day) {
			return false;
		}
		if (month != other.month) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return (this.getDay() +"/" +this.getMonth()+"/" +this.getYear());
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
