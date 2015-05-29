package com.yeahmobi.rundemo.guavaexample.eventbus;

import com.google.common.eventbus.Subscribe;

//只需要在要订阅消息的方法上加上@Subscribe注解即可实现对多个消息的订阅
public class MultipleListener {
	public Integer lastInteger;  
    public Long lastLong;  
   
    @Subscribe  
    public void listenInteger(Integer event) {  
        lastInteger = event; 
        System.out.println("Msg Integer:"+lastInteger);
    }  
   
    @Subscribe  
    public void listenLong(Long event) {  
        lastLong = event; 
        System.out.println("Msg Long:"+lastLong);
    }  
   
    public Integer getLastInteger() {  
        return lastInteger;  
    }  
   
    public Long getLastLong() {  
        return lastLong;  
    }  
}
