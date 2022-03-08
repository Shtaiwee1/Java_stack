package com.zookeeperpart1;

public class Gorilla extends Mammal {
	
	
	
	public Integer throwSomething() {
		System.out.println("the gorilla threw something");
		this.energyLevel-=5;
		return this.energyLevel;
	}
	public Integer eatBananas() {
		System.out.println("the gorilla is very happy");
		this.energyLevel+=10;
		return this.energyLevel;
	}
	public Integer climb(){
		System.out.println("the gorilla has climbed a tree");
		this.energyLevel-=10;
		return this.energyLevel;
	}
}
