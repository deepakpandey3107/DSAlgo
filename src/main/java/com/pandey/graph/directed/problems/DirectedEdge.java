package com.pandey.graph.directed.problems;

import java.text.DecimalFormat;

public class DirectedEdge implements Comparable<DirectedEdge>{
	
	private Integer from, to;
	private Double distance;
	private Vehicle vehicle;
	private Double weight;
	public DirectedEdge(Integer from, Integer to, Double distance, Vehicle vehicle) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.vehicle = vehicle;
		this.weight = distance/vehicle.getSpeed();
	}

	public Double getWeight(){
		return this.weight;
	}
	
	public Integer getFrom() {
		return from;
	}
	
	public Integer getTo() {
		return to;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public Double getDistance() {
		return distance;
	}

	@Override
	public int compareTo(DirectedEdge that) {
		return this.getWeight().compareTo(that.getWeight());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.000"); 

		sb.append(from);sb.append("--(");
		sb.append(vehicle.type);
		sb.append(" speed=");sb.append(vehicle.getSpeed());
		sb.append(" dist=");sb.append(distance);
		sb.append(" time=");sb.append(df.format(weight));
		sb.append(")-->");
		sb.append(to);
		return sb.toString() ;
	}
}

