package com.yeahmobi.rundemo.guavaexample.eventbus;

import com.google.common.eventbus.Subscribe;

public class NumberListener {
	private Number lastMessage;  
	   
    @Subscribe  
    public void listen(Number integer) {  
        lastMessage = integer; 
        System.out.println("Message:"+lastMessage);
    }  
   
    public Number getLastMessage() {  
        return lastMessage;  
    }  
}

class IntegerListener {  
    
    private Integer lastMessage;  
   
    @Subscribe  
    public void listen(Integer integer) {  
        lastMessage = integer; 
        System.out.println("Message:"+lastMessage);
    }  
   
    public Integer getLastMessage() {  
        return lastMessage;  
    }  
}  
