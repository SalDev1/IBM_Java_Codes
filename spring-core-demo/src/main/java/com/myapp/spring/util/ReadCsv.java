package com.myapp.spring.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class ReadCsv {
	// You can have generic type in class declaration and method declaration.
	// Aim :- Read the file + convert into specific types.
	public <T> List<T> convertToList(Class<T>type, String filename) {
		
	   CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	   
	   CsvMapper csvMapper = new CsvMapper(); // reading line and line and map it.
	   
	   try {
		   File file = new ClassPathResource(filename).getFile();
		   // Mapping the data to a specific type. 
		   
		   MappingIterator<T>iterator = csvMapper.reader(type).with(bootstrapSchema).readValues(file);
		   
		   return iterator.readAll();
	   }
	   catch (IOException e) {
		   e.printStackTrace();
		   return Collections.emptyList();
	   }
	}
}
