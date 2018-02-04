package com.mangohacks2018.server;

public class Person {
	private String name;				// person name
	private String activity;			// their desired activity
	private double longitude;		// user location
	private double latitude;			// user location
	
	// constructor given everything
	public Person(String name, String activity, double longitude, double latitude) {
		this.name = name;
		this.activity = activity;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	// lazy person constructor for miamian coordinates
	public Person(String name, String activity) {
		this.name = name;
		this.activity = activity;
		this.latitude = (Math.random() * 0.147335) + 25.663776;
		this.longitude = (Math.random() * -0.129654) - 80.286697;
	}
	
	// basic getters
	public String getName() {
		return name;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	// string representation
	public String toString() {
		return name + " " + activity + " " ;
	}
	
}
