package com.tsantos.facade;

public class ThreadMaker {
	private ThreadShape thread;

	public ThreadMaker() {
		thread = new ThreadSortTextFile();

	}

	public void generateThreadSortText() {
		thread.run();
		Thread t1 = new Thread(new ThreadSortTextFile(), "A");
		Thread t2 = new Thread(new ThreadSortTextFile(), "B");
		t1.start();
		t2.start();
	}

}
