package com.cxz.testSynchronized;

/**
 * 静态代理实现12306购票系统
 * 使用饿汉单例设计模式获得真实角色对象
 * 好处：使用接口编程便避免单继承的局限性、便于真实角色的资源共享
 * @author sowhat
 *
 */
public class TestWeb12306 {
	
	public static void main(String[] args) {
		// 真实角色
		Web12306 web = Web12306.getWeb();
		
		Thread t1 = new Thread(web, "学生党");
		Thread t2 = new Thread(web, "黄牛党");
		Thread t3 = new Thread(web, "攻城狮");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

// 真实角色，利用饿汉单例设计模式获得对象
class Web12306 implements Runnable{
	private static Web12306 web = new Web12306();
	private int num = 50 ;
	private int xs,hn,gcs;
	
	private Web12306() {	}
	
	public static Web12306 getWeb(){
		return web;
	}
	
	private boolean flag = true;
	@Override
	public void run() {
		String tName = Thread.currentThread().getName();
		
		while (flag) {
			buy(tName);
		}
	}
	
	private synchronized void buy(String tName){
		if(num<=0){
			flag=false;
			return;
		}
		if("学生党".equals(tName)){
			xs+=1;
			System.out.println(tName+"抢到"+xs+"张票了，剩余票数："+--num+"张");
		}
		if("黄牛党".equals(tName)){
			hn+=1;
			System.out.println(tName+"抢到"+hn+"张票了，剩余票数："+--num+"张");
		}
		if("攻城狮".equals(tName)){
			gcs+=1;
			System.out.println(tName+"抢到"+gcs+"张票了，剩余票数："+--num+"张");
		}
		
		try {
			Thread.sleep(5000);  // 模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void buy2(String tName){
		synchronized (this) {
		if(num<=0){
			flag=false;
			return;
		}
		if("学生党".equals(tName)){
			xs+=1;
			System.out.println(tName+"抢到"+xs+"张票了，剩余票数："+--num+"张");
		}
		if("黄牛党".equals(tName)){
			hn+=1;
			System.out.println(tName+"抢到"+hn+"张票了，剩余票数："+--num+"张");
		}
		if("攻城狮".equals(tName)){
			gcs+=1;
			System.out.println(tName+"抢到"+gcs+"张票了，剩余票数："+--num+"张");
		}
		}
		
		try {
			Thread.sleep(5000);  // 模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}