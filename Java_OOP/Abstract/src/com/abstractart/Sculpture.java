package com.abstractart;

public class Sculpture extends Art {
	public String material;
	
	//constructor
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}
	
	
	

	//setters and getters

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}



//abstract method
	
	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		String result = "";
		result += "Title:       " + getTitle() + "\n";
		result += "Author:      " + getAuthor() + "\n";
		result += "Description: " + getDescription() + "\n";
		result += "paintType:   " + material + "\n";
		System.out.println(result);
		
	}

}
