package com.cxz.TestJoin;

/**
 * ��Ա����
 * join���̺߳ϲ�
 * ������ǰ�̣߳��������̺߳ϲ�
 * @author sowhat
 *
 */
public class TestJoin extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("join������������������"+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		TestJoin t = new TestJoin();   // ����
		t.start();    // ����
		// cpu��������
		
		for (int i = 0; i < 100; i++) {
			if(50 == i)
				t.join();   // mian��������
			System.out.println("main����������������������"+i);
		}
	}
}
