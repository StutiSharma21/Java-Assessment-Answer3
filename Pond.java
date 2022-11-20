import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pond implements Runnable{
	ArrayList<String> fishes;
	ReentrantLock lock;
	
	public Pond(ArrayList<String> fishes, ReentrantLock lock) {
		this.fishes = fishes;
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true) {
			if(lock.tryLock()) {
				try {
					if(fishes.isEmpty())
						break;
					else {
						List<String> newFishes = new ArrayList<>(List.of("m","m","f","f"));
						
						Random rand = new Random();
						int idx1 = rand.nextInt(fishes.size());
						String fish1 = fishes.get(idx1);
						
						int idx2 = rand.nextInt(fishes.size());
						String fish2 = fishes.get(idx2);
						
						if(fish1 == "m" && fish2 == "m") {
							fishes.remove(idx1);
							fishes.remove(idx2);
						}
						else if(fish1 == "f" && fish2 == "f") {
							fishes.remove(idx1);
							
						}
						else {
							String newFish1 = newFishes.get(rand.nextInt(newFishes.size()));
							String newFish2 = newFishes.get(rand.nextInt(newFishes.size()));
							fishes.add(newFish1);
							fishes.add(newFish2);
						}
						
						System.out.println(fishes);
				
					}
				}
					finally {
					lock.unlock();
				}
			}

		}
	}
}
