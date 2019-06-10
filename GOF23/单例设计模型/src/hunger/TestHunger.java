package hunger;

public class TestHunger{
	
	public static void main(String[] args) {
		Hunger h1 = Hunger.getInstance();
		Hunger h2 = Hunger.getInstance();
		
		Test t1 = new Test();
		Test t2 = new Test();
		
//		System.out.println(h1.equals(h2));
//		System.out.println(h1.hashCode());
//		System.out.println(h2.hashCode());
		h1.addCount();
		h2.addCount();
		
		System.out.println("**************************");
		
		t1.addCount();
		t2.addCount();
//		System.out.println(t1.equals(t2));
//		System.out.println(t1.hashCode());
//		System.out.println(t2.hashCode());
	}
}
