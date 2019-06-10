package com.cxz.ThreadIsLive;

public class MyThread implements Runnable{

//	private boolean.
	@Override
	public void run() {
		int i=0;
		while (true) {
			i++;
			System.out.println(Thread.currentThread().getName()+"运行的步数："+i);
		}
	}
}
