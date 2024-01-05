package threadingtest;

import java.util.Random;

public class SingleFieldChangeOfTwoFieldsLock implements Runnable {
	private long c1 = 0;
	private long c2 = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void inc1() {
		synchronized (lock1) {
			c1++;
		}
	}

	public void inc2() {
		synchronized (lock2) {
			c2++;
		}
	}

	@Override
	public void run() {
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
		System.out.println("c1 Lock " + c1);
		System.out.println("c2 Lock " + c2);
	}
}
