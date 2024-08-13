package com.soumya;

import java.util.concurrent.*;

public class ExecutorServiceDemo1
{
    static void process(){
        
    
            
         System.out.println(Thread.currentThread().getName()+" executing process");
         
 		ExecutorService service = Executors.newFixedThreadPool(8);
 		
		service.submit(() -> m());
		
		// m();
         service.shutdown();
        
         System.out.println(Thread.currentThread().getName()+" finished executing process");
         
    }
	private static void m() {
         
        System.err.println(Thread.currentThread().getName()+" executing in m()");
        System.err.println(Thread.currentThread().getName()+" finished executing m()");

		
	}
	public static void main(String[] args)throws Exception{
		
		ExecutorService service = Executors.newFixedThreadPool(8);
		
		for(int i=1;i<=5;i++){
		    
		   service.submit(() -> process());
//			new Thread(() -> process()).start();

		}
		
		for(int i=1;i<=5;i++){
		  System.out.println("Hello World");
		  //Thread.sleep(1);
		}
		System.out.println("main terminated");
		
		//System.out.println(future.get());
	
	    service.shutdown();
	}
}