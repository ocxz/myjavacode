package com.cxz.ThreadCreat;

/**
 * 模拟龟兔赛跑中的兔子
 * @author sowhat
 *
 */
public class Rabbit extends Thread{

	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("兔子跑了几步"+i);
		}
	}
}
