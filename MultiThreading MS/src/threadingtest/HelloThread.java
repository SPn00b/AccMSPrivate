package threadingtest;

public class HelloThread extends Thread {
	@Override
	public void run() {
		System.out.println("Hello from a thread!");
		currentThread().setName("SanishThread1");
		System.out.println("priority " + getPriority());
		System.out.println("Thread Group " + currentThread().getThreadGroup());
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " from thread " + currentThread().getId());
		}
		System.out.println("name " + currentThread().getName());
	}
}
