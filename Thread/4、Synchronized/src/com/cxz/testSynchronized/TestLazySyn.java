package com.cxz.testSynchronized;

/**
 * 模拟测试懒汉式设计模式的线程不安全
 * @author sowhat
 */

public class TestLazySyn {

	public static void main(String[] args) {
//		JVM jvm1 = JVM.getInstance((long)500);
//		JVM jvm2 = JVM.getInstance((long)200);
		
		Thread t1 = new Thread(new GetJVMThread(500L), "垃圾回收线程A");
		Thread t2 = new Thread(new GetJVMThread(300L), "垃圾回收线程B");
		
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
		System.out.println(Thread.currentThread().getName()+"-->创建"+JVM.getInstance2(time));
	}
}

/**
 * 懒汉设计模式，双重检测
 * @author sowhat
 *
 */
class JVM{
	
	// 构造一个静态变量，懒于构造
	private static JVM instance = null;
	// 私有化构造器
	private JVM(){ }
	// 对外提供对象获得入口
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
		
		
		// 双重检测
		if(instance==null){    // 判断是否加锁，提高效率
			synchronized(JVM.class){
				if(instance==null){   // 判断是否已创建，确保安全
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
