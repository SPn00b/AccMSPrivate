package _MultiThreading_Gradle.threadingtest;

public class HelloRunnableJoinNext implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// for (int i = 10000; i < 99999; i++) {
		for (int i = 11; i < 21; i++) {
			System.out.println(i);
		}
	}

}
