package com.cxz.TestProxy;

/**
 * ��̬����ģʽ�ĳ���ѧϰ
 * �����������ɫ����ʵ��ɫ
 * 1�������ɫ����ʵ��ɫʵ��ͬһ���ӿ�
 * 2�������ɫ������ʵ��ɫ������
 * @author sowhat
 *
 */
public class TestProxy {

	public static void main(String[] args) {
		// ��ʵ��ɫ����ʵ����
		Marry you = new You();
		// �����ɫʵ����
		Marry company = new WeddingCompany(you);
		// �����ɫ������
		company.marry();
	}
}

interface Marry{
	void marry();
}

// ��ʵ��ɫ
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("����϶�����");
	}
	
}

// �����ɫ
class WeddingCompany implements Marry{
	private Marry you;
	
	public WeddingCompany() {
		super();
	}
	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}

	private void before(){
		System.out.println("׼���鷿");
	}

	private void after() {
		System.out.println("��ɻ������");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}




