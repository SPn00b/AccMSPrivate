package threadingtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import threadingtest.Deadlock.Friend;
import threadingtest.Safelock.BowLoop;

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

		// Synchronize used when using different threads created on same object
		// and try to modify or when static value is changed from different different
		// objs
		// synchronize uses intrinsic/monitor lock
		// use reentrent locks no extra care needed when synchronize block calls
		// other synchronize method
		SynchronizedCounter sC1 = new SynchronizedCounter();

		tH9 = new Thread(sC1);
		tH10 = new Thread(sC1);
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

		// Without Sleep value is not yet finised
		SingleFieldChangeOfTwoFieldsLock sFC1 = new SingleFieldChangeOfTwoFieldsLock();

		tH9 = new Thread(sFC1);
		tH10 = new Thread(sFC1);
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

		// Without Sleep value is not yet finised
		SingleFieldChangeOfTwoFieldsSynchronized sFCS1 = new SingleFieldChangeOfTwoFieldsSynchronized();

		tH9 = new Thread(sFCS1);
		tH10 = new Thread(sFCS1);
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

		// as synchronize works on objects this 2 are different objects and
		// hence work independently and work simultaneously which we don't want to
		// happen
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(() -> alphonse.bow(gaston)).start();
		new Thread(() -> gaston.bow(alphonse)).start();

//		final Friend alphonse1 = new Friend("Alphonse");
//		final Friend gaston1 = new Friend("Gaston");
//		new Thread(() -> alphonse1.bow(gaston1)).start();
//		new Thread(() -> gaston1.bow(alphonse1)).start();

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

		// bowing with locks with try lock and unlock methods
		System.out.println("Starting safelock!!!");
		final Safelock.Friend alphonse1 = new Safelock.Friend("Alphonse");
		final Safelock.Friend gaston1 = new Safelock.Friend("Gaston");
		tH9 = new Thread(new BowLoop(alphonse1, gaston1));
		// .start();
		tH10 = new Thread(new BowLoop(gaston1, alphonse1));
		// .start();

		tH9.start();
		tH10.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tH9.interrupt();
		tH10.interrupt();
		try {
			tH9.join(1000);
			tH10.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Executor executor = Executors.newFixedThreadPool(8);
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);

		executor.execute(() -> System.out.println("Test exe"));
		executorService.submit(() -> System.out.println("Test exe submit service"));
		scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Test exe sch with fixed delay"), 5000,
				5000, TimeUnit.MILLISECONDS);

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executorService.shutdown();
		scheduledExecutorService.shutdown();

		// FixedThreadPool good for http request for sustained performance and server
		// does not cripple under load
		// instead server takes what it can perform and hold other request in queue for
		// waiting.

		// CachedThreadPool is expandable thread pool good for short lived tasks

		// single for single task at a time

		// work stealing good for max usage of computer resources for performance
		// double queue/Dqueue takes tasks from head of own queue and from tail of
		// others queue
		// stealing can lead to non determinism in cpu cache prefetching which can
		// impact via cache miss
		// but still over all better in usage of all hardware resources for tasks.

		// Own ThreadPool -> use ThreadPoolExecutor/ScheduledThreadPoolExecutor for
		// creation

		// Fork-Join Thread Pool Java 1.7 ->
		// Worker Threads used to run tasks on
		// F-J TP will break task in subtask and work on it
		// used in parallel stream
		// hence use with care where task division can cause wrong answers
		// in bracket based calculation means where 1st add then multiply such MAC
		// operation can give wrong answers

		// ForkJoinPool class, an extension of the AbstractExecutorService class

		try {
			Thread.sleep(5000);
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

		// Atomic
		AtomicCounter aC1 = new AtomicCounter();

		tH9 = new Thread(aC1);
		tH10 = new Thread(aC1);

		tH9.start();
		tH10.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

//use instead of Math.random for better performance in concurrency 
		int r = ThreadLocalRandom.current().nextInt(4, 77);

	}
}
