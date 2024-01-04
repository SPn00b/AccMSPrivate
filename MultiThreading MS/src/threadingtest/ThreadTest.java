package threadingtest;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloThread hT1 = new HelloThread();
		HelloThread hT2 = new HelloThread();
		hT1.start();
		// cannot run thread using extend Thread 2 times from same object throws
		// java.lang.IllegalThreadStateException
//		try {
//			Thread.sleep(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		hT1.start();
		hT2.start();

		HelloRunnable hR1 = new HelloRunnable();
		HelloRunnable hR2 = new HelloRunnable();
		Thread tH3 = new Thread(hR1);
		Thread tH4 = new Thread(hR2);

		tH3.start();
		tH4.start();

		// tH3.start();

		try {
			Thread.currentThread().sleep(10);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread tH5 = new Thread(hR1);
		tH5.setPriority(1);
		tH5.start();
		tH5 = new Thread(hR1);
		tH5.setPriority(10);
		tH5.start();

		try {
			Thread.currentThread().sleep(1000);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HelloRunnableDeamon hRD1 = new HelloRunnableDeamon();
		Thread tH6 = new Thread(hRD1);
		tH6.setDaemon(true);
		tH6.start();
//uncomment this to check working of deamon thread.
//		while (true) {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			System.out.println("Deamon thread running " + tH6.isAlive());
//			System.out.println("Deamon thread is Daemon " + tH6.isDaemon());
//
//		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tH6.interrupt();
		System.out.println("Deamon thread is interupted? " + tH6.isInterrupted());
		System.out.println("Deamon thread is Daemon " + tH6.isDaemon());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		HelloRunnableJoin tRJ = new HelloRunnableJoin();
		HelloRunnableJoinNext tRJN = new HelloRunnableJoinNext();

		Thread tH7 = new Thread(tRJ);
		Thread tH8 = new Thread(tRJN);

		tH7.start();
		try {
			tH7.join();
			Thread.sleep(2000);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tH8.start();

		ThreadInterference iT1 = new ThreadInterference();
		// ThreadInterference iT2 = new ThreadInterference();

		Thread tH9 = new Thread(iT1);
		Thread tH10 = new Thread(iT1);

		try {
			Thread.sleep(2000);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tH9.start();
		tH10.start();

		try {
			Thread.sleep(2000);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SynchronizedCounter sC1 = new SynchronizedCounter();

		tH9 = new Thread(sC1);
		tH10 = new Thread(sC1);
		tH9.start();
		tH10.start();

	}

}
