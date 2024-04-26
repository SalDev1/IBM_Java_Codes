package com.myapp.collections;

public record Flight(String flightNo, String sourceCity, String destinationCity, Double fare, Double duration) implements Comparable<Flight>{
	@Override
	public int compareTo(Flight o) {
		return fare.compareTo(o.fare);
	}
}
