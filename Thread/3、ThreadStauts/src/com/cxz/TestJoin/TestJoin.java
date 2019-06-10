package com.cxz.TestJoin;

/**
 * 成员方法
 * join：线程合并
 * 阻塞当前线程，将其他线程合并
 * @author sowhat
 *
 */
public class TestJoin extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("join。。。。。。。。。"+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		TestJoin t = new TestJoin();   // 新生
		t.start();    // 就绪
		// cpu调度运行
		
		for (int i = 0; i < 100; i++) {
			if(50 == i)
				t.join();   // mian方法阻塞
			System.out.println("main。。。。。。。。。。。"+i);
		}
	}
}
