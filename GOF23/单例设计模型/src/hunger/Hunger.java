package hunger;

/**
 * 用来学习单例模式中的饿汉式实现
 * 核心思想：  1、类加载是创建对象（利用一个static变量来实现）
 * 		  2、私有化构造器，不允许外界创建对象
 *        3、提供方法，返回对象（利用一个public static 方法来对外提供入口）
 * 特点：虚拟机转载类时，只会有一个对象，不会发生并行访问的问题
 * @author sowhat
 *
 */
public class Hunger implements IaddCount{

	// 定义一个static对象，用来保存呢哇出来的单例对象
	private static final Hunger hunger = new Hunger();
	private  int count = 0;

	// 私用化构造器
	private Hunger(){	}
	
	// 提供入口方法
	public static synchronized Hunger getInstance(){
		return hunger;
	}
	
	// 提供一个逻辑方法
	public  void  addCount(){
		count++;
		System.out.println("当前count数"+count);
	}
	
}

class Test implements IaddCount{
	private  int count = 0;
	
	public synchronized void addCount(){
		count++;
		System.out.println("当前count数"+count);
	}
}
