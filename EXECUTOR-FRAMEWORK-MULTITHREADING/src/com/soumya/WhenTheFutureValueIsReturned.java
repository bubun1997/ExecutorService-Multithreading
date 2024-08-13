package com.soumya;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhenTheFutureValueIsReturned {

	static int process1() {
		
		for(int i=1;i<=10;i++) {
		
			System.out.println(Thread.currentThread().getName()+" executing !!");

		}
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(()-> process2());
		//new Thread(()-> process2()).start();
		
		
		System.out.println(Thread.currentThread().getName()+" finished executing !!");

		service.shutdown();
		
		return 1;

		
	}
	static void process2() {
		
		System.out.println(Thread.currentThread().getName()+" executing !!");
		System.out.println(Thread.currentThread().getName()+" sleeping !!");
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" finished executing !!");


	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Future<Integer> futureObj = service.submit(WhenTheFutureValueIsReturned::process1);
		
		System.out.println(Thread.currentThread().getName()+" waiting for future Object !!");

		
		System.out.println(futureObj.get());
		
		System.out.println(Thread.currentThread().getName()+" terminated !!");
		
		service.shutdown();
	}

}
