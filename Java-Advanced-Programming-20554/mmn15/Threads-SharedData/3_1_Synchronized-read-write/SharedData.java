import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
	private double x = 0;
	private double y = 0;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	public double calc(){
		lock.readLock().lock();;
		try{
			return (x+y)/2;
		}finally{
			lock.readLock().unlock();
		}
	}
	
	public void store(double x, double y){
		lock.writeLock().lock();
		try{
			this.x = x;
			this.y = y;
		}finally{
			lock.writeLock().unlock();
		}
		
	}
}
