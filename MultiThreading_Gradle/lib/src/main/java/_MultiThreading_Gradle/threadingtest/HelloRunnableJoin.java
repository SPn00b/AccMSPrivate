package _MultiThreading_Gradle.threadingtest;

public class HelloRunnableJoin implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// for (int i = 1; i < 9999; i++) {
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}
	}

}
