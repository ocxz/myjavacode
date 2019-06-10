package com.cxz.ThreadIsLive;

public class MainThread {

	public  static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread, "线程一");
		Thread thread2 = new Thread(myThread, "线程二");
		
		// 设置优先级
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.setPriority(Thread.MAX_PRIORITY);
		
		
		thread.start();
		thread2.start();
		System.out.println(Thread.currentThread().getName()+"*******************************************************************8");
		System.out.println(thread.isAlive());
		Thread.sleep(30);
		
		thread.stop();
		thread2.stop();
		Thread.sleep(100);
		System.out.println(thread.isAlive());
		System.out.println(Thread.currentThread().getName());
	}
}
