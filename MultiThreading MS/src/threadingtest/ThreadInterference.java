package threadingtest;

public class ThreadInterference implements Runnable {
	private int c = 0;

	public void increment() {
		for (int i = 0; i < 100; i++) {
			c++;
		}

	}

	public void decrement() {
		for (int i = 0; i < 100; i++) {
			c--;
		}
	}

	public int value() {
		return c;
	}

	@Override
	public void run() {
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
		System.out.println("thread interference c " + c);
		System.out.println("thread interference value " + value());
	}
}
