package com.soumya;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceWithException {

	 static void process(){
	        
		    
         
         System.out.println(Thread.currentThread().getName()+" executing...");
		        
        
         System.out.println(Thread.currentThread().getName()+" finished executing...");
         
         System.out.println(1/0);
         
         System.out.println(Thread.currentThread().getName()+" ended...");
          
//         try{Thread.sleep(6000);}
//         catch(Exception e){}
        
    }
	public static void main(String[] args)throws Exception{
		
		ExecutorService service = Executors.newFixedThreadPool(8);
		Future<?> future =null;
		
		for(int i=1;i<=5;i++){
		    
		    future = service.submit(() -> process());
//			new Thread(() -> process()).start();

		}
		
		for(int i=1;i<=5;i++){
		  System.out.println("Hello World");
		  Thread.sleep(2);
		}
		System.out.println("main terminated");
		
	    service.shutdown();

		System.out.println(future.get());
	
	}
}
