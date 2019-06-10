package com.cxz.TestProxy;

/**
 * 静态代理模式的初步学习
 * 条件：代理角色、真实角色
 * 1、代理角色和真实角色实现同一个接口
 * 2、代理角色持有真实角色的引用
 * @author sowhat
 *
 */
public class TestProxy {

	public static void main(String[] args) {
		// 真实角色代理实例化
		Marry you = new You();
		// 代理角色实例化
		Marry company = new WeddingCompany(you);
		// 代理角色代理结婚
		company.marry();
	}
}

interface Marry{
	void marry();
}

// 真实角色
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("你和嫦娥姐姐结婚");
	}
	
}

// 代理角色
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
		System.out.println("准备婚房");
	}

	private void after() {
		System.out.println("完成婚后事宜");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}




