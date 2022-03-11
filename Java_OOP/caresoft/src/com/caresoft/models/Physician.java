package com.caresoft.models;

import java.sql.Date;
import java.util.ArrayList;

import com.caresoft.clinicapp.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin<=9999 && pin>=1000) {
			this.pin = pin;
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(confirmedAuthID == this.id) {
			return true;
		}else {
		return false;
		}
	}
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
    	super(id);
    }
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    public void setpatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
    
    public ArrayList<String> getpatientNotes(){
    	return patientNotes;
    }
	

}
