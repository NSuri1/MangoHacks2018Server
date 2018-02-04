package com.mangohacks2018.server;

import java.util.ArrayList;

public class PeopleList {
	private ArrayList<Person> peopleList;	// entire list of people stored in mem
	
	public PeopleList(boolean wantDummyData) {
		peopleList = new ArrayList<>();
		
		if (wantDummyData) {
			// fill in dummy data for demo
			addDummyData();
		}
		
	}
	
	public void addPersonToList(Person p) {
		peopleList.add(p);
	}
	
	public ArrayList<Person> getPeopleList() {
		return peopleList;
	}
	
	public String toString() {
		return peopleList.toString();
	}

	private void addDummyData() {
		addPersonToList(new Person("Angelo can compute", "Hack"));
		addPersonToList(new Person("Jenny from the blockchain", "Hack"));
		addPersonToList(new Person("Jessica", "Hack"));
		addPersonToList(new Person("Cesia", "Hack"));
		addPersonToList(new Person("Alastair", "Hack"));
		addPersonToList(new Person("Gavin", "Hack"));
		addPersonToList(new Person("Daniel", "Study"));
		addPersonToList(new Person("Diana", "Study"));
		addPersonToList(new Person("Kenny", "Study"));
		addPersonToList(new Person("Ivette", "Study"));
		addPersonToList(new Person("Gertrude", "Study"));
		addPersonToList(new Person("Bartholomeau", "Study"));
		addPersonToList(new Person("Carlos", "Gym"));
		addPersonToList(new Person("Jane", "Gym"));
		addPersonToList(new Person("Luis", "Gym"));
		addPersonToList(new Person("Stephan", "Gym"));
		addPersonToList(new Person("Joseph", "Gym"));
		addPersonToList(new Person("Cason", "Gym"));
		addPersonToList(new Person("Anthony", "Watch Movies"));
		addPersonToList(new Person("Samantha", "Watch Movies"));
		addPersonToList(new Person("Randy", "Watch Movies"));
		addPersonToList(new Person("Carolina", "Watch Movies"));
		addPersonToList(new Person("Rania", "Watch Movies"));
		addPersonToList(new Person("Lisa", "Watch Movies"));
	}
}
