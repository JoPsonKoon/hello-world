package org.thread;

public class TimerTaskThreadTest extends Thread {
	public TimerTaskThreadTest() {
		super.setName("TimerTaskThread");
	}

	@Override
	public void run() {
		super.run();
		try {
			aaa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void aaa() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			System.out.println("aaa" + i);
		}
	}

	public static void main(String[] args) {
		// 启动线程
		TimerTaskThreadTest taskThread1 = new TimerTaskThreadTest();
		TimerTaskThreadTest taskThread2 = new TimerTaskThreadTest();
		taskThread1.start();
		taskThread2.start();

	}
}
