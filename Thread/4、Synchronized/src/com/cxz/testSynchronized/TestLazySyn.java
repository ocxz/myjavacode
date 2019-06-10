package com.cxz.testSynchronized;

/**
 * ģ���������ʽ���ģʽ���̲߳���ȫ
 * @author sowhat
 */

public class TestLazySyn {

	public static void main(String[] args) {
//		JVM jvm1 = JVM.getInstance((long)500);
//		JVM jvm2 = JVM.getInstance((long)200);
		
		Thread t1 = new Thread(new GetJVMThread(500L), "���������߳�A");
		Thread t2 = new Thread(new GetJVMThread(300L), "���������߳�B");
		
		t1.start();
		t2.start();
		
	}
}

class GetJVMThread implements Runnable{
	private long time;
	
	public GetJVMThread() {
		super();
	}

	public GetJVMThread(long time) {
		super();
		this.time = time;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->����"+JVM.getInstance2(time));
	}
}

/**
 * �������ģʽ��˫�ؼ��
 * @author sowhat
 *
 */
class JVM{
	
	// ����һ����̬���������ڹ���
	private static JVM instance = null;
	// ˽�л�������
	private JVM(){ }
	// �����ṩ���������
	public synchronized static JVM getInstance(long time) {
		
		if(instance==null){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				instance = new JVM();
		}
		return instance;
		}
	
	public static JVM getInstance2(long time) {
		
		
		// ˫�ؼ��
		if(instance==null){    // �ж��Ƿ���������Ч��
			synchronized(JVM.class){
				if(instance==null){   // �ж��Ƿ��Ѵ�����ȷ����ȫ
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						instance = new JVM();
				}
			}
		}
		return instance;
	}
}
