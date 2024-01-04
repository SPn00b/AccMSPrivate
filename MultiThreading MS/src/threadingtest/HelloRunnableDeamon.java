package threadingtest;

public class HelloRunnableDeamon implements Runnable {

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			Thread.currentThread();
//		if (Thread.currentThread().isInterrupted()) {
//			System.out.println("Yes");
//		}
			// Thread.currentThread().setDaemon(true);
//		System.out.println("Daemon thread ran succesfully");
//		System.out.println("Daemon thread priority " + Thread.currentThread().getPriority());
//		System.out.println("Daemon thread id " + Thread.currentThread().getId());
//		System.out.println("Daemon thread group " + Thread.currentThread().getThreadGroup());
			// while (true) {
			// try {
			Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
//			if (Thread.currentThread().isInterrupted()) {
//				System.out.println("Yes");
//			}
			// }
			System.out.println("Daemon thread ran succesfully");
			System.out.println("Daemon thread priority " + Thread.currentThread().getPriority());
			System.out.println("Daemon thread id " + Thread.currentThread().getId());
			System.out.println("Daemon thread group " + Thread.currentThread().getThreadGroup());
			// }
			while (true) {
				Thread.currentThread();
				// try {
				Thread.sleep(1000);
				// } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
//				if (Thread.currentThread().isInterrupted()) {
//					System.out.println("Yes");
//				}
				// Thread.interrupted();
				// }
				System.out.println("Sleep wake");
//			if (Thread.currentThread().isInterrupted()) {
//				System.out.println("Yes");
//			}
			}
		} catch (InterruptedException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Yes");
			}
			System.out.println("intrupted!!!!");
		}
	}

}
