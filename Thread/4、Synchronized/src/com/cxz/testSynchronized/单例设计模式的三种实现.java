package com.cxz.testSynchronized;

public class 单例设计模式的三种实现 {

}

// 懒汉式
class MyJVM{
	private static MyJVM instance = null;
	private MyJVM(){ }
	
	public MyJVM getMyJVM(){
		if(instance == null){
			synchronized (MyJVM.class) {
				if(instance == null){
					instance = new MyJVM();
				}
			}
		}
		return instance;
	}
}

// 饿汉式  类加载时便创建对象
class MyJVM2{
	private static MyJVM2 instance = new MyJVM2();
	private MyJVM2(){ }
	public MyJVM2 getMyJVM2() {
		return instance;
	}
}

// 饿汉式和懒汉式结合版  延时加载
// 类在使用的时候才会加载，加载MyJVM3不一定会加载JVMholder,只用使用了getMyJVM3才会加载
class MyJVM3{
	private static class JVMholder{
		private static MyJVM3 instance = new MyJVM3();
	}
	
	private MyJVM3(){ };
	public MyJVM3 getMyJVM3(){
		return JVMholder.instance;
	}
}
