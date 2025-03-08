package _MultiThreading_Gradle.threadingtest;

import java.util.Random;

public class SingleFieldChangeOfTwoFieldsSynchronized implements Runnable {
	private long c1 = 0;
	private long c2 = 0;

	public synchronized void inc1() {
		c1++;
	}

	public synchronized void inc2() {
		c2++;
	}

	public synchronized long value1() {
		return c1;
	}

	public synchronized long value2() {
		return c2;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		Random rD = new Random();
		int decision = rD.nextInt(2);
		System.out.println(decision);
		if (decision > 0) {
			for (int i = 0; i < 100; i++) {
				inc1();
			}
		} else {
			for (int i = 0; i < 100; i++) {
				inc2();
			}
		}
		// Without Sleep value is not yet finised
//		try {
//			Thread.currentThread().sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("c1 Sync " + c1);
		System.out.println("c2 Sync " + c2);
		System.out.println("c1 Sync val " + value1());
		System.out.println("c2 Sync val " + value2());
	}
}
