package com.caresoft.models;

public class User {
 	protected Integer id;
    protected int pin;
    
 // TO DO: Getters and setters
    public void setId(Integer id) {
    	this.id = id;
    	
    }
    
    public void setPin(int pin) {
    	this.pin = pin;
    	
    }
    
    public Integer getId() {
    	return id;
    	
    }
    
    public int getPin() {
    	return pin;
    	
    }
// Implement a constructor that takes an ID
    public User(Integer id) {
    	this.id = id;
    }

}
