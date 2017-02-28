package test;

public class Fibonacci {

	public static void main(String[] args) {
		
		for(int i=1; i <= 10; i++) {
			System.out.println(fib(i));
		}
		
		//System.out.println(fib(3));
	}
	/*
	public static int fib(int n) {
		int a = 0, b = 1 , c;
		if(n == 1)
			return b;
		for(int i=2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	*/
	
	public static int fib(int num) {
		if(num == 0)
			return 0;
		if(num==1 || num==2)
			return 1;
		int[] fib = new int[num+1];
		fib[1]=1;
		for(int i=2; i<=num; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[num];
	}
	
}
