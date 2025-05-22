package in.practice;

import java.util.concurrent.CompletableFuture;

public class Sample1 {
	int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public void even() {
		for (int a : array) {
			if (a % 2 == 0) {
				System.out.println(Thread.currentThread() + " " + a);
			}
		}
	}

	public void odd() {
		for (int a : array) {
			if (a % 2 != 0) {
				System.out.println(Thread.currentThread() + " " + a);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Sample1 printer = new Sample1();
		Thread evenPrinter = new Thread(() -> printer.even());
		Thread oddPrinter = new Thread(() -> printer.odd());
		
		oddPrinter.start();
		oddPrinter.join();
		evenPrinter.start();
		
		
	}
}
