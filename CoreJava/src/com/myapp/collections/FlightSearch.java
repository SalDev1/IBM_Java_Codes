package com.myapp.collections;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightSearch {
	
	public List<Flight> search(String sourceCity, String destinationCity) {
		Path path = Path.of("data/flights.csv");
		
		List<Flight> flights = null;
		try(Stream<String>lines = Files.lines(path);) {
			  flights = 
					  lines.filter(line -> !line.startsWith("#"))
					  .flatMap(line-> LineToFlight(line))
					  .collect(Collectors.toList());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flights.stream().filter(flight -> 
				flight.sourceCity().equalsIgnoreCase(sourceCity) && 
				flight.destinationCity().equalsIgnoreCase(destinationCity))
                    .sorted(Comparator.comparing(Flight::fare)
                    		.thenComparing(Flight::duration)).toList();

	}
	
	public static void main(String[] args) {
		FlightSearch flightSearch = new FlightSearch();
		flightSearch.search("Bengaluru","Mumbai")
		   .forEach(System.out::println);
	}
	
	// Aim :- Read the csv.file and return the matching data as a list + 
	// sort based on the duration.
	
	private Stream<Flight> LineToFlight(String line){
		try {
			String elements [] = line.split(",");
			return Stream.of(new Flight(elements[0],elements[1],elements[2],
					Double.parseDouble(elements[3]),Double.parseDouble(elements[4])));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Stream.empty();
	}
}
