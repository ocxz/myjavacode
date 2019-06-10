package com.cxz.ThreadCreat;

/**
 * 利用静态代理模式，来实现多线程
 * 代理角色：Thread类
 * 真实角色：实现Runnable接口
 * Thread new构造对象时传入真实角色
 * 代理执行的方法：run()方法
 * 
 * @author sowhat
 *
 */
public class MyThread {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new SpThread("线程一"));
		Thread thread2 = new Thread(new SpThread("线程二"));
		thread1.start();
		thread2.start();
		
		
	}
}

class SpThread implements Runnable{
	private String threadName;

	public SpThread() {
		super();
	}
	public SpThread(String threadName) {
		super();
		this.threadName = threadName;
	}


	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("静态代理模式，"+threadName+"执行的步数："+i);
		}
	}
	
}
