import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class InfinitePond {

	public static void main(String[] args) {
		ArrayList<String> fishes = new ArrayList<>(List.of("m","m","m","m","m","m","m","m","m","m","f","f","f","f","f","f","f","f","f","f"));
		ReentrantLock lock = new ReentrantLock();
		
		Pond p1 = new Pond(fishes,lock);
		Thread t1 = new Thread(p1);
		t1.start();
		
		Pond p2 = new Pond(fishes,lock);
		Thread t2 = new Thread(p1);
		t2.start();
		
		Pond p3 = new Pond(fishes,lock);
		Thread t3 = new Thread(p1);
		t3.start();
		
		Pond p4 = new Pond(fishes,lock);
		Thread t4 = new Thread(p1);
		t4.start();
		
		Pond p5 = new Pond(fishes,lock);
		Thread t5 = new Thread(p1);
		t5.start();
		
	}

}
