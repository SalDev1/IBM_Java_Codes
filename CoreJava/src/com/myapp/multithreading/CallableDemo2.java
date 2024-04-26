package com.myapp.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CallableDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Old School of Doings Things.
		// Anoyomous Inner Class
		Callable<Integer> callable = new Callable<Integer>() {
			  @Override
			  public Integer call() throws Exception {
				  int count = 0;
				  for(int i = 0 ; i< 10 ; i++) {
					  Thread.sleep(500);
					  count += i;
				  }
				  return count;
			  }
		};
		
		// New way of doing things.
		Callable<Integer> callable1 = () -> {
			int count = 0;
			for(int i = 0 ; i < 10 ; i++) {
				Thread.sleep(500);
				count += i;
			}
			return count;
		};
		// Assigning a thread pool. 
		// Executor is a framework + newScheduledThreadPool is a thread too.
		// Submit the task as well.
		
		// Creating 10 worker threads + Compare with JavaScript promises.
		// This is an example of loose coupling , as any available thread gets assigned 
		// to a task.
		//ExecutorService executors = Executors.newScheduledThreadPool(10);
		
		// future --> An object returning a future
		// Future<Integer>future = executors.submit(callable1);
		
		// Using Scheduled Executor Service.
		ScheduledExecutorService executors = Executors.newScheduledThreadPool(10);
		Future<Integer> future = executors.schedule(callable, 500, TimeUnit.MILLISECONDS);
		
		try {
			Integer value = future.get();
			System.out.println("Value "+ value);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executors.shutdown();
	}

}
