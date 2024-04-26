package com.myapp.core.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {

	public ReadingFiles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Path.of("data/file1-ISO.txt");
		
		// To check if the file exists or not , we use. 
		boolean exists = Files.exists(path);
		
		System.out.println("File exists "+ exists);
		
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
		try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.ISO_8859_1)) {
			String line = reader.readLine();			
			while(line != null) {
				System.out.println("Line= "+line);
				line = reader.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
