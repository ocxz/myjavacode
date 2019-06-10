package com.cxz.TestYeild;


/**
 * 静态方法，通过Thread.yeild()方法调用
 * yeild：暂停执行本次本线程，让出本次cpu的调度
 * @author sowhat
 *
 */
public class TestYeild extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("join。。。。。。。。。"+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		TestYeild t = new TestYeild();   // 新生
		t.start();    // 就绪
		// cpu调度运行
		
		for (int i = 0; i < 100; i++) {
			if(i%10==0)
				Thread.yield();   // mian方法阻塞
			System.out.println("main。。。。。。。。。。。"+i);
		}
	}
}
