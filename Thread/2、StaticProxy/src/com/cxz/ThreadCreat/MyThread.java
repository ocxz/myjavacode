package com.cxz.ThreadCreat;

/**
 * ���þ�̬����ģʽ����ʵ�ֶ��߳�
 * �����ɫ��Thread��
 * ��ʵ��ɫ��ʵ��Runnable�ӿ�
 * Thread new�������ʱ������ʵ��ɫ
 * ����ִ�еķ�����run()����
 * 
 * @author sowhat
 *
 */
public class MyThread {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new SpThread("�߳�һ"));
		Thread thread2 = new Thread(new SpThread("�̶߳�"));
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
			System.out.println("��̬����ģʽ��"+threadName+"ִ�еĲ�����"+i);
		}
	}
	
}
