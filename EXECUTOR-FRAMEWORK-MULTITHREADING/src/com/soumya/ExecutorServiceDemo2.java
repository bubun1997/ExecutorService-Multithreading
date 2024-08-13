package com.soumya;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo2 {

	public static void main(String[] args) throws InterruptedException {
        
		ExecutorService service = Executors.newFixedThreadPool(6);
		
		service.submit(() -> m());
		
		service.shutdown();
		
		for(int i=1;i<=5;i++){
			  System.out.println("Hello World");
			  //Thread.sleep(1);
		}
		
		System.out.println("main terminated");
		
	}

	private static String m() {
		
		System.err.println(Thread.currentThread().getName()+" executing in m()");
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        System.err.println(Thread.currentThread().getName()+" finished executing m()");
        
		return "Hii";
	}

}
