package com.myapp.core;

public class Demo2 {
	public static void main(String[] args) {
//	    int array1[] = {1,2,3,4,5};    
//	    double array2[] = {785.7,897,907.5};
//	    
//	    int max_val = Integer.MIN_VALUE;
//	    int min_val = Integer.MAX_VALUE;
//	    
//	    double max_val_1 = Integer.MIN_VALUE;
//	    double min_val_1 = Integer.MAX_VALUE;
//	    
//	    for(int i = 0 ; i < array1.length ; i++) {
//	    	max_val = Math.max(max_val,array1[i]);
//	    	min_val = Math.min(min_val, array1[i]);
//	    }
//	    
//	    for(int i = 0 ; i < array2.length ; i++) {
//	    	max_val_1 = Math.max(max_val_1,array2[i]);
//	    	min_val_1 = Math.min(min_val_1, array2[i]);
//	    }
//	    
//	    System.out.print(max_val);
//	    System.out.print(" ");
//	    System.out.print(min_val);
//	    
//	    System.out.print(" ");
//	    System.out.print(max_val_1);
//	    System.out.print(" ");
//	    System.out.print(min_val_1);
	    
	    
	    MinMaxArray<Integer> arr3 = new MinMaxArrayImpl<>(1,2,3,4,5);
	    MinMaxArray<Double> arr4 = new MinMaxArrayImpl<>(12.0,7.35,9.87);
	    
		System.out.println("Min Value "+arr3.min());
		System.out.println("Max Value "+arr3.max());
		
		System.out.println("Min Value "+arr4.min());
		System.out.println("Max Value "+arr4.max());
	}
}
