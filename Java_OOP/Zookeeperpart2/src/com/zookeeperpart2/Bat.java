package com.zookeeperpart2;

public class Bat extends Mammal {
	
	public Integer fly() {
		System.out.println("The bat is taking off");
		this.energyLevel-=50;
		return this.energyLevel;
	}
	
	public Integer eatHumans() {
		System.out.println("The bat ate a human");
		this.energyLevel+=25;
		return this.energyLevel;
		
	}
	public Integer attackTown() {
		System.out.println("The bat attacked a town");
		this.energyLevel-=100;
		return this.energyLevel;
		
	}
}
