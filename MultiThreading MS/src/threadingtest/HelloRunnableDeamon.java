package threadingtest;

public class HelloRunnableDeamon implements Runnable {

	@Override
	public void run() {
		// Thread.currentThread().setDaemon(true);
		// TODO Auto-generated method stub
		System.out.println("Daemon thread ran succesfully");
		System.out.println("Daemon thread priority " + Thread.currentThread().getPriority());
		System.out.println("Daemon thread id " + Thread.currentThread().getId());
		System.out.println("Daemon thread group " + Thread.currentThread().getThreadGroup());
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Daemon thread ran succesfully");
			System.out.println("Daemon thread priority " + Thread.currentThread().getPriority());
			System.out.println("Daemon thread id " + Thread.currentThread().getId());
			System.out.println("Daemon thread group " + Thread.currentThread().getThreadGroup());
		}
	}

}
