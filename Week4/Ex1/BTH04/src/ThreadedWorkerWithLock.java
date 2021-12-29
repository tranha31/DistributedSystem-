
public class ThreadedWorkerWithLock extends Thread {
	private ResourcesExploiterWithLock rExp;
	
	public void run() {
		for(int i=0; i<1000; i++) {
			rExp.exploit();
		}
	}
	
	public ThreadedWorkerWithLock(ResourcesExploiterWithLock rExp) {
		this.rExp = rExp;
	}

	public static void main(String args[]) {
		ResourcesExploiterWithLock resource = new ResourcesExploiterWithLock(0);
		ThreadedWorkerWithLock worker1 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker2 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker3 = new ThreadedWorkerWithLock(resource);
	
		worker1.start();
		worker2.start();
		worker3.start();
		
		try {
			worker1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			worker2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			worker2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resource.getRsc());
		
	}
}
