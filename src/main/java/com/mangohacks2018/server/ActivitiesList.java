package com.mangohacks2018.server;

public class ActivitiesList {
	
	final String[] activities = {
		"Hack", "Study", "Gym", "Watch Movies"	
	};	// list of supported activities
	
	public ActivitiesList() {
		// empty constructor
	}
	
    public String[] getActivities() {
        return activities;		// basic getter
    }
}
