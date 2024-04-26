package com.myapp.core.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class AnalyzeCsvFiles {

	public AnalyzeCsvFiles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Path.of("data/products.csv");
		
		// To check if the file exists or not , we use. 
		boolean exists = Files.exists(path);
		
//		System.out.println("File exists "+ exists);
//		
//		BufferedReader reader = null;
//		try {
//			reader = Files.newBufferedReader(path)
//		} catch(IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// Files.lines() will return a Stream Interface of Type String named lines;
		// This is a new way of reading the file. 
		/*
		 * Using lines() to read each line in the path.
		 * 
		 * Stream will help you to hold the data for us and analyze the data. 
		 * Stream is immutable in nature , only read and analyze it.
		 * */
		Predicate<String> predicate = line -> !line.startsWith("#");
		
		try(Stream<String> lines = Files.lines(path);) {
			// We are skipping the first line for now.
			
			// Get each row , map them to object and then start analyzing the data then.
//			lines.filter(line -> !line.startsWith("#")).forEach(line -> System.out.println(line));
			lines.filter(predicate)
			  //.flatMap(AnalyzeCsvFiles :: lineToProduct)  // Another of writing the lambda.
			  .flatMap(line -> lineToProduct(line))   // Second way of writing the lambda. 
			  .filter(p -> p.price() > 5000.0)
			  // .forEach(System.out::println);
			  .forEach(p -> System.out.println(p));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		private static Stream<Product> lineToProduct(String line){
			String elements [] = line.split(",");
			
			try {
			  return Stream.of(new Product(Integer.parseInt(elements[0]), elements[1], 
						Double.parseDouble(elements[2])));
			} catch(NumberFormatException e) {
				e.printStackTrace();
			} 
			return Stream.empty();
		}
	}

