/**
 * A class for testing the Threads and the shared data
 * 
 * @author (amir dror) 
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunThreads {
	public static void main(String[] args){
		SharedData data = new SharedData();
		Thread1 T1 = new Thread1(data);
		Thread2 T2 = new Thread2(data);
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(T1);
		executor.execute(T2);
		executor.shutdown();
	}
}
