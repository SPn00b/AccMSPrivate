package _MultiThreading_Gradle.threadingtest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Runnable {
	private AtomicInteger c = new AtomicInteger(0);

	public void increment() {
		for (int i = 0; i < 100; i++) {
			c.incrementAndGet();
		}
	}

	public void decrement() {
		for (int i = 0; i < 100; i++) {
			c.decrementAndGet();
		}
	}

	public int value() {
		return c.get();
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
		System.out.println("Atomic counter c " + c);
		System.out.println("Atomic counter value " + value());
	}

}
