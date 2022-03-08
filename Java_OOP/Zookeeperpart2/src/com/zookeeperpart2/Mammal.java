package com.zookeeperpart2;

public class Mammal {

	public Integer energyLevel = 300;


	public Integer displayEnergy() {
		System.out.println("the energy level is" + this.energyLevel);
		return this.energyLevel;	
	}
}
