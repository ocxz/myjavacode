package com.cxz.ThreadCreat;

/**
 * ģ����������е�����
 * @author sowhat
 *
 */
public class Rabbit extends Thread{

	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("�������˼���"+i);
		}
	}
}
