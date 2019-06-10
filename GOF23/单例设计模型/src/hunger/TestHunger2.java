package hunger;

public class TestHunger2 {

	public static void main(String[] args) {
		
		
		Thread thread1 = new TestHungerThread("1");
		Thread thread2 = new TestHungerThread("2");
		
		thread1.start();
		thread2.start();
	}
}

class TestHungerThread extends Thread{
	
	private String ThreadName;
	private IaddCount iaddCount;
	
	public TestHungerThread() {
		super();
//		iaddCount = Hunger.getInstance();
	}

	public TestHungerThread(String threadName) {
		super();
		ThreadName = threadName;
	}

	@Override
	public void run() {
//		iaddCount = Hunger.getInstance();
		System.out.println("开始执行线程"+ThreadName);
		while(true) {
			iaddCount = Hunger.getInstance();
			iaddCount.addCount();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
