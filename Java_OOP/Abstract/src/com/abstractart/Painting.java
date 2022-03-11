package com.abstractart;

public class Painting extends Art {
	public String paintType;
	
	//constructor
	public Painting(String title , String author , String description , String paintType) {
		super(title,author,description);
		this.paintType = paintType;
		
	}
	
	
	//setters and getters

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	
	
	//abstract method

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		String result = "";
		result += "Title:       " + getTitle() + "\n";
		result += "Author:      " + getAuthor() + "\n";
		result += "Description: " + getDescription() + "\n";
		result += "paintType:   " + paintType + "\n";
		System.out.println(result);
		
	}

	

}
