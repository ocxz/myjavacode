package com.cxz.TestYeild;


/**
 * ��̬������ͨ��Thread.yeild()��������
 * yeild����ִͣ�б��α��̣߳��ó�����cpu�ĵ���
 * @author sowhat
 *
 */
public class TestYeild extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("join������������������"+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		TestYeild t = new TestYeild();   // ����
		t.start();    // ����
		// cpu��������
		
		for (int i = 0; i < 100; i++) {
			if(i%10==0)
				Thread.yield();   // mian��������
			System.out.println("main����������������������"+i);
		}
	}
}
