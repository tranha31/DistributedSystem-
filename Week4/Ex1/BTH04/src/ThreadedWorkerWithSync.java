
public class ThreadedWorkerWithSync extends Thread {
	private ResourcesExploiter rExp;
	
	public void run() {
		synchronized(rExp) {
			for(int i=0; i<1000; i++) {
				rExp.exploit();
			}
		}
		
	}
	
	public ThreadedWorkerWithSync(ResourcesExploiter rExp) {
		this.rExp = rExp;
	}

	public static void main(String args[]) {
		ResourcesExploiter resource = new ResourcesExploiter(0);
		ThreadedWorkerWithSync worker1 = new ThreadedWorkerWithSync(resource);
		ThreadedWorkerWithSync worker2 = new ThreadedWorkerWithSync(resource);
		ThreadedWorkerWithSync worker3 = new ThreadedWorkerWithSync(resource);
	
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
