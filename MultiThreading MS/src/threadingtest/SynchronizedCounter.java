package threadingtest;

public class SynchronizedCounter implements Runnable {
	private int c = 0;

	public synchronized void increment() {
		for (int i = 0; i < 100; i++) {
			c++;
		}

	}

	public synchronized void decrement() {
		for (int i = 0; i < 100; i++) {
			c--;
		}
	}

	public synchronized int value() {
		return c;
	}

	@Override
	public synchronized void run() {
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		increment();
		decrement();
		System.out.println("Sync counter c " + c);
		System.out.println("Sync counter value " + value());
	}
}
