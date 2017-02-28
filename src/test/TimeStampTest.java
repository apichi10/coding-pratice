package test;

import java.util.Date;

public class TimeStampTest {

	public static void main(String[] args) throws InterruptedException {
		long time = new Date().getTime();
		System.out.println(time);
		Thread.sleep(1000);
		System.out.println(new Date().getTime() - time);
	}

}
