package com.cxz.testSynchronized;

/**
 * ��̬����ʵ��12306��Ʊϵͳ
 * ʹ�ö����������ģʽ�����ʵ��ɫ����
 * �ô���ʹ�ýӿڱ�̱���ⵥ�̳еľ����ԡ�������ʵ��ɫ����Դ����
 * @author sowhat
 *
 */
public class TestWeb12306 {
	
	public static void main(String[] args) {
		// ��ʵ��ɫ
		Web12306 web = Web12306.getWeb();
		
		Thread t1 = new Thread(web, "ѧ����");
		Thread t2 = new Thread(web, "��ţ��");
		Thread t3 = new Thread(web, "����ʨ");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

// ��ʵ��ɫ�����ö����������ģʽ��ö���
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
		if("ѧ����".equals(tName)){
			xs+=1;
			System.out.println(tName+"����"+xs+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		if("��ţ��".equals(tName)){
			hn+=1;
			System.out.println(tName+"����"+hn+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		if("����ʨ".equals(tName)){
			gcs+=1;
			System.out.println(tName+"����"+gcs+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		
		try {
			Thread.sleep(5000);  // ģ����ʱ
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
		if("ѧ����".equals(tName)){
			xs+=1;
			System.out.println(tName+"����"+xs+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		if("��ţ��".equals(tName)){
			hn+=1;
			System.out.println(tName+"����"+hn+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		if("����ʨ".equals(tName)){
			gcs+=1;
			System.out.println(tName+"����"+gcs+"��Ʊ�ˣ�ʣ��Ʊ����"+--num+"��");
		}
		}
		
		try {
			Thread.sleep(5000);  // ģ����ʱ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}