package threadingtest;

public class HelloRunnable implements Runnable {
	// int priority = 5;

	@Override
	public void run() {
		if (Thread.interrupted()) {
			System.out.println("Interupted!!!");
			// Thread.currentThread().interrupt();
		}
		// TODO Auto-generated method stub
		System.out.println("Hello from a thread!");
		Thread.currentThread().setName("SanishThread2");
		System.out.println(
				"priority " + Thread.currentThread().getPriority() + "thread id = " + Thread.currentThread().getId());
		System.out.println("Thread Group " + Thread.currentThread().getThreadGroup());
		// Thread.currentThread().setPriority(priority);
		// System.out.println("priority " + Thread.currentThread().getPriority());
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " from thread " + Thread.currentThread().getId());
		}
		System.out.println("name " + Thread.currentThread().getName());
	}

}
