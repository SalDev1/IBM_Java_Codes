package com.myapp.multithreading;

public class RunnableDemo1 {
  public static void main(String[] args) {
	
	  // Old Way --> Anonymous Inner Classes.
//	  Runnable runnable = new Runnable() {
//		  @Override 
//		  public void run() {
//			  //
//	  for(int i = 0 ; i < 10 ; i++) {
//			 System.out.println("Current Thread: "+ Thread.currentThread().getName()+" "+i);
//
//			 // sleep will raised the checked exception.
//			 try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//				// This will cause an interrupt exception.
//				Thread.currentThread().interrupt();
//				break;
//			}
//		 }
//		  }
//	  };
	  
	 // New Way --> Lambda Functions.
	  
	  // Asking the loop to run 10 times + assigning each task to each thread.
	  // Runnable comes under Functional Interface + having one abstract method + right candidates 
	  // for handling lambda expressions.
	  
	   Runnable runnable = () -> {
		   for(int i = 0 ; i < 10 ; i++) {
				 System.out.println("Current Thread: "+ Thread.currentThread().getName()+" "+i);

				 // sleep will raised the checked exception.
				 try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// This will cause an interrupt exception.
					Thread.currentThread().interrupt();
					break;
				}
			 }
	   };
	   
	   
		  // This is an example of tight coupling , 
	     // Task execution and worker are tightly coupled.
		 
	     Thread worker1 = new Thread(runnable,"Worker1");
		 Thread worker2 = new Thread(runnable,"Worker2");
		 
		 try {
			worker1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  worker1.run();
		  worker2.run();
	   };
   }
