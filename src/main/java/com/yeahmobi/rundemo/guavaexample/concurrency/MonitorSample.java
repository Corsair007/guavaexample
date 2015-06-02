package com.yeahmobi.rundemo.guavaexample.concurrency;

import java.util.ArrayList;
import java.util.List;

import com.google.common.util.concurrent.Monitor;

/**
 * @rundemo_name 使用Monitor控制并发
 * @desc Monitor就像java原生的synchronized,
 *       ReentrantLock一样，每次只允许一个线程执行代码块，且可重占用，每一次占用要对应一次退出占用。
 * @author root
 *
 */
public class MonitorSample {

	/**
	 * 通过Monitor的Guard进行条件阻塞
	 */
	private List<String> list = new ArrayList<String>();
	private static final int MAX_SIZE = 10;
	private Monitor monitor = new Monitor();

	private Monitor.Guard listBelowCapacity = new Monitor.Guard(monitor) {
		@Override
		public boolean isSatisfied() {
			return list.size() < MAX_SIZE;
		}
	};

	public void addToList(String item) throws InterruptedException {
		monitor.enterWhen(listBelowCapacity); // Guard(形如Condition)，不满足则阻塞，而且我们并没有在Guard进行任何通知操作
		try {
			list.add(item);
		} finally {
			monitor.leave();
			System.out.println("leave--" + item);
		}
	}

	public static void main(String[] args) throws InterruptedException {
	
	}

}