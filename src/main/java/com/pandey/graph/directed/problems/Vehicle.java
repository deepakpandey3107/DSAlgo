package com.pandey.graph.directed.problems;

public class Vehicle   {
	
	Double speed;
	VehicleType type;
	
	
	public Vehicle(Double speed, VehicleType type) {
		this.speed = speed;
		this.type = type;
	}

	public Double getSpeed() {
		return speed;
	}
	
	public VehicleType getType() {
		return type;
	}
}
