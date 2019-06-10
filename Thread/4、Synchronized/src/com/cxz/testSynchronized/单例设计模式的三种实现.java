package com.cxz.testSynchronized;

public class �������ģʽ������ʵ�� {

}

// ����ʽ
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

// ����ʽ  �����ʱ�㴴������
class MyJVM2{
	private static MyJVM2 instance = new MyJVM2();
	private MyJVM2(){ }
	public MyJVM2 getMyJVM2() {
		return instance;
	}
}

// ����ʽ������ʽ��ϰ�  ��ʱ����
// ����ʹ�õ�ʱ��Ż���أ�����MyJVM3��һ�������JVMholder,ֻ��ʹ����getMyJVM3�Ż����
class MyJVM3{
	private static class JVMholder{
		private static MyJVM3 instance = new MyJVM3();
	}
	
	private MyJVM3(){ };
	public MyJVM3 getMyJVM3(){
		return JVMholder.instance;
	}
}
