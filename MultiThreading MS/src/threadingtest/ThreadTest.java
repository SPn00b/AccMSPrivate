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

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Deamon thread is Daemon " + tH6.isAlive());
			System.out.println("Deamon thread running " + tH6.isDaemon());

		}

	}

}
