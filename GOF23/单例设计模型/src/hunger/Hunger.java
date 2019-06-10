package hunger;

/**
 * ����ѧϰ����ģʽ�еĶ���ʽʵ��
 * ����˼�룺  1��������Ǵ�����������һ��static������ʵ�֣�
 * 		  2��˽�л�����������������紴������
 *        3���ṩ���������ض�������һ��public static �����������ṩ��ڣ�
 * �ص㣺�����ת����ʱ��ֻ����һ�����󣬲��ᷢ�����з��ʵ�����
 * @author sowhat
 *
 */
public class Hunger implements IaddCount{

	// ����һ��static���������������۳����ĵ�������
	private static final Hunger hunger = new Hunger();
	private  int count = 0;

	// ˽�û�������
	private Hunger(){	}
	
	// �ṩ��ڷ���
	public static synchronized Hunger getInstance(){
		return hunger;
	}
	
	// �ṩһ���߼�����
	public  void  addCount(){
		count++;
		System.out.println("��ǰcount��"+count);
	}
	
}

class Test implements IaddCount{
	private  int count = 0;
	
	public synchronized void addCount(){
		count++;
		System.out.println("��ǰcount��"+count);
	}
}
