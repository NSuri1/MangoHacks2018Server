package com.mangohacks2018.server;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
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
    public PeopleList getPeopleListByActivity(@RequestParam(value="activityType", defaultValue="Hack") 
    											String activityType) {
        
    		ArrayList<Person> arrList = new PeopleList(true).getPeopleList();
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