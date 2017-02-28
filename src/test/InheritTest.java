package test;

public class InheritTest {
	
	private int num = 10;
	
	public void print() {
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		InheritChild it = new InheritChild();
		((InheritTest)it).print();
	}

}

class InheritChild extends InheritTest {
	
	int num = 99;
	
	public void print() {
		super.print();
		System.out.println(num);
	}
}