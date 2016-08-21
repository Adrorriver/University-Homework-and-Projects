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
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
			executor.execute(new Thread1(data));
			executor.execute(new Thread2(data));
		}
		executor.shutdown();
	}
}
