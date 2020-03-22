package com.ferb.json_demo_01;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	
        	Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
        	
        	System.out.println("First name: " + student.getFirstName());
        	System.out.println("Last name: " + student.getLastName());
        	
        	Address address = student.getAddress();
        	System.out.println("Street: " + address.getStreet());
        	for(String language: student.getLanguages()) {
        		System.out.println("Language: " + language);
        	}
        	
        } catch (Exception e) {
        	e.printStackTrace();
		}
    }
}
