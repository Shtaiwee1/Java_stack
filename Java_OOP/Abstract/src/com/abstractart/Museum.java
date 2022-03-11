package com.abstractart;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {
	public static void main(String[] args) {
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(new Painting("The Boating Party", "Mary Cassatt", "woman, man, and child on small sailboat", "oil on canvas"));
		museum.add(new Painting("Red Canna", "Georgia O'Keefe", "red flowers in a vase", "watercolor on paper"));
		museum.add(new Painting("Der Kuss", "Gustav Klimpt", "a couple embrace", "oil and gold leaf on canvas"));
		museum.add(new Sculpture("Winged Victory of Samothrace", "unknown", "depicts the goddess Nike", "marble"));
		museum.add(new Sculpture("David", "Michelangelo", "depicts biblical figure David", "marble"));
		
		Collections.shuffle(museum);
		
		for(Art artwork : museum) {
			artwork.viewArt();
			
	}
	}
}
	

