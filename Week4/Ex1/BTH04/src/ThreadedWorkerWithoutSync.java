
public class ThreadedWorkerWithoutSync extends Thread {
	private ResourcesExploiter rExp;
	
	public void run() {
		for(int i=0; i<1000; i++) {
			rExp.exploit();
		}
		
		
	}
	
	public ThreadedWorkerWithoutSync(ResourcesExploiter rExp) {
		this.rExp = rExp;
	}

	public static void main(String args[]) {
		ResourcesExploiter resource = new ResourcesExploiter(0);
		ThreadedWorkerWithoutSync worker1 = new ThreadedWorkerWithoutSync(resource);
		ThreadedWorkerWithoutSync worker2 = new ThreadedWorkerWithoutSync(resource);
		ThreadedWorkerWithoutSync worker3 = new ThreadedWorkerWithoutSync(resource);
	
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
