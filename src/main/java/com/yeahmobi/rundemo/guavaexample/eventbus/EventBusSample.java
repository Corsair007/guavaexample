package com.yeahmobi.rundemo.guavaexample.eventbus;

import com.google.common.eventbus.EventBus;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 事件处理机制
 * @desc EventBus是Guava的事件处理机制，是设计模式中的观察者模式（生产/消费者编程模型）的优雅实现。对于事件监听和发布订阅模式，
 *       EventBus是一个非常优雅和简单解决方案，我们不用创建复杂的类和接口层次结构。使用Guava之后, 如果要订阅消息,
 *       就不用再继承指定的接口, 只需要在指定的方法上加上@Subscribe注解即可
 * @author root
 *
 */
public class EventBusSample {

	public static void main(String[] args) throws Exception {
		EventBusSample eventBusSample = new EventBusSample();
		eventBusSample.testReceiveEvent();
		dividingLine();
		eventBusSample.testMultipleEvents();
		dividingLine();
		// 如果EventBus发送的消息都不是订阅者关心的称之为Dead Event
		// 如果没有消息订阅者监听消息， EventBus将发送DeadEvent消息，这时我们可以通过log的方式来记录这种状态
		eventBusSample.testDeadEventListeners();
		dividingLine();
		// Event的继承：
		// 如果Listener A监听Event A, 而Event A有一个子类Event B, 此时Listener A将同时接收Event
		// A和B消息，实例如下：
		/**
		 * 在这个方法中,我们看到第一个事件(新的整数(100))是收到两个听众,但第二个(新长(200l))
		 * 只能到达NumberListener作为整数一不是创建这种类型的事件 。
		 * 可以使用此功能来创建更通用的监听器监听一个广泛的事件和更详细的具体的特殊的事件。
		 */
		eventBusSample.testEventsFromSubclass();
	}

	public void testReceiveEvent() throws Exception {

		EventBus eventBus = new EventBus("test");
		EventListener listener = new EventListener();

		eventBus.register(listener);

		eventBus.post(new TestEvent(200));
		eventBus.post(new TestEvent(300));
		eventBus.post(new TestEvent(400));

		System.out.println("LastMessage:" + listener.getLastMessage());
	}

	public void testMultipleEvents() throws Exception {

		EventBus eventBus = new EventBus("test");
		MultipleListener multiListener = new MultipleListener();

		eventBus.register(multiListener);

		eventBus.post(new Integer(100));
		eventBus.post(new Integer(200));
		eventBus.post(new Integer(300));
		eventBus.post(new Long(800));
		eventBus.post(new Long(800990));
		eventBus.post(new Long(800882934));

		System.out.println("LastInteger:" + multiListener.getLastInteger());
		System.out.println("LastLong:" + multiListener.getLastLong());
	}

	public void testDeadEventListeners() throws Exception {

		EventBus eventBus = new EventBus("test");
		DeadEventListener deadEventListener = new DeadEventListener();
		eventBus.register(deadEventListener);

		eventBus.post(new TestEvent(200));
		eventBus.post(new TestEvent(300));

		System.out.println("deadEvent:" + deadEventListener.isNotDelivered());

	}

	public void testEventsFromSubclass() throws Exception {

		EventBus eventBus = new EventBus("test");
		IntegerListener integerListener = new IntegerListener();
		NumberListener numberListener = new NumberListener();
		eventBus.register(integerListener);
		eventBus.register(numberListener);

		eventBus.post(new Integer(100));

		System.out.println("integerListener message:"
				+ integerListener.getLastMessage());
		System.out.println("numberListener message:"
				+ numberListener.getLastMessage());

		eventBus.post(new Long(200L));

		System.out.println("integerListener message:"
				+ integerListener.getLastMessage());
		System.out.println("numberListener message:"
				+ numberListener.getLastMessage());
	}
}
