package com.server;

import java.util.concurrent.Exchanger;

 public class SendAndReceiver {
   
   private final Exchanger<StringBuilder> exchanger=new Exchanger<StringBuilder>();
   
   private class Sender implements Runnable{
	
	public void run() {
		
	   try{
		   StringBuilder content=new StringBuilder("Hello");
		   content=exchanger.exchange(content);
		   System.out.println("##"+content);
	     }catch(InterruptedException e){
		    Thread.currentThread().interrupt();
	   }
	     
     }
  }
  
  private  class  Receiver implements Runnable{
	 
	public void run() {
	    try{
	        StringBuilder content=new StringBuilder("World");
	        content=exchanger.exchange(content);
	        System.out.println("##"+content);
	    }catch(Exception e){
	    	 Thread.currentThread().interrupt();
	    }
	 }
	
 }
  
  
  public  void exchange(){
	  
	  new Thread(new Sender()).start();
	  new Thread(new Receiver()).start();
	  
  }
   
    public static void main(String[] args) throws Exception{
    	
        SendAndReceiver  t=new SendAndReceiver();
        t.exchange();
        
    }
	
	
  }
	
	
	
	
 
