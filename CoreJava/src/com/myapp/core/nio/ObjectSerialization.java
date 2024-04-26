package com.myapp.core.nio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialization {
		// TODO Auto-generated constructor stub
	    public static void main(String[] args) {
	    	
	    	// We are persisting the object of type Product.
	    	// We are going to serializiable this --> storing the entire thing into the file.
	    	
	    	// Array of products --> 
	    	Product products[] = {
	    	  new Product(1,"Iphone15",75456.7),
	    	  new Product(2,"OnePlus12",65478.8),
	    	  new Product(3,"OnePlus11R",55456.5)
	    	};
	    	
	    	// Handling binary data.
	    	// Converting an object into the stream of bytes --> Serialization.
	    	
	    	// Aim :- Converting an object into the stream of bytes , using ObjectOutputStream
	    	try (ObjectOutputStream oos = new ObjectOutputStream(
	    			new FileOutputStream("tmp.obj"))) {
	    		oos.writeObject(products);
	    		
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
}
