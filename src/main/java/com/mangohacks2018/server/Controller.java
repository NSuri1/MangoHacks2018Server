package com.mangohacks2018.server;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	public static ArrayList<Person> arrList = new PeopleList(true).getPeopleList();
    
    @RequestMapping("/")
    public String homePage() {
        return "Welcome to the API";
    }
	
    @RequestMapping("/activities")
    public ActivitiesList activities() {
    		// return list of supported activities
        return new ActivitiesList();
    }
    
    @RequestMapping(value = "/activities/people", method = RequestMethod.POST)
    public PeopleList addPersonToList(@RequestParam(value="activityType", defaultValue="Hack") 
    											String activityType, @RequestParam(value="name", defaultValue="Joe Shmoe") 
                                                String name, @RequestParam(value="long", defaultValue="-73.985428") 
                                                double longitude, @RequestParam(value="lat", defaultValue="40.748817") 
                                                double latitude) {
    		// add person to list and return updated list
        arrList.add(new Person(name, activityType, longitude, latitude));
        
        return filterListByActivity(activityType);
    }
    
    @RequestMapping(value = "/activities/people", method = RequestMethod.GET)
    public PeopleList getPeopleListByActivity(@RequestParam(value="activityType", defaultValue="Hack") 
    											String activityType) {
    		// return unmodified list
    		return filterListByActivity(activityType);
    }
    
    @RequestMapping(value = "/activities/people", method = RequestMethod.DELETE)
    public boolean deletePersonFromList(@RequestParam(value="activityType", defaultValue="") 
    											String activityType, @RequestParam(value="name", defaultValue="") 
                                                String name) {
    		// delete a user from the list and return whether deletion was successful
    		int index = -1;
        for (int i = 0; i < arrList.size(); i++) {
        		Person p = arrList.get(i);
        		if (p.getActivity().equalsIgnoreCase(activityType) && p.getName().equalsIgnoreCase(name)) {
        			index = i;
        			break;
        		}
        }
        
        if (index != -1) {
        		arrList.remove(index);
        		return true;
        } else {
        		return false;
        }
    }
    
    public PeopleList filterListByActivity(String activityType) {
    		PeopleList listToReturn = new PeopleList(false);
        
        // only return people with same activity
        // PS, there is a better way to do this but demoing...
        // also, later add filter/preprocessing for location radius
        for (Person p : arrList) {
        		if (p.getActivity().equalsIgnoreCase(activityType)) {
        			listToReturn.addPersonToList(p);
        		}
        }
        
        return listToReturn;
    }
    
    

}