package com.yeahmobi.rundemo.guavaexample.eventbus;

import com.google.common.eventbus.Subscribe;

//消息接受类
public class EventListener {
	public int lastMessage = 0;

	@Subscribe
	public void listen(TestEvent event) {
		lastMessage = event.getMessage();
		System.out.println("Message:" + lastMessage);
	}

	public int getLastMessage() {
		return lastMessage;
	}
}
