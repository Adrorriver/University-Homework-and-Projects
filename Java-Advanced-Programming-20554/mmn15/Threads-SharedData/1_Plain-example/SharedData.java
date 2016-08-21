
public class SharedData {
	private double x = 0;
	private double y = 0;
	
	public double calc(){
		return (x+y)/2;
	}
	
	public void store(double x, double y){
		this.x = x;
		this.y = y;
	}
}
