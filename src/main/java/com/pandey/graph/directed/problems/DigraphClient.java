package com.pandey.graph.directed.problems;

import java.util.Stack;

public class DigraphClient {

	public static void main(String[] args) {
		Integer V = 5; Integer s = 0; Integer v= 4 ;
		Double cycleSpeed = 12d; Double bikeSpeed = 25d;
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(V);
		addEdge(graph, 0, 1, 5d, 0, cycleSpeed, bikeSpeed);
		addEdge(graph, 0, 2, 2d, 1, cycleSpeed, bikeSpeed);
		addEdge(graph, 0, 3, 5d, 0, cycleSpeed, bikeSpeed);
		addEdge(graph, 1, 4, 5d, 0, cycleSpeed, bikeSpeed);
		addEdge(graph, 2, 4, 2d, 1, cycleSpeed, bikeSpeed);
		addEdge(graph, 3, 4, 5d, 0, cycleSpeed, bikeSpeed);
		
		DigraphProcessor processor = new DigraphProcessor(graph, s);
		System.out.println("hasPath:" +processor.hasPathTo(v));
		System.out.println("time needed:" +processor.timeTo(v));

		Stack<DirectedEdge> path = processor.path(v);
		if(path != null){
			while(!path.isEmpty()){
			System.out.println(path.pop().toString());
			}
		}
		
	}
	
	private static void addEdge(EdgeWeightedDigraph graph, Integer from, Integer to, Double distance, 
						Integer both, Double cycleSpeed, Double bikeSpeed){
		DirectedEdge cycleEdge = new DirectedEdge(from, to, distance, new Vehicle(cycleSpeed, VehicleType.BICYCLE) );
		graph.addEdge(cycleEdge);
		if(both==0){
			DirectedEdge bikeEdge = new DirectedEdge(from, to, distance, new Vehicle(bikeSpeed, VehicleType.BIKE) );
			graph.addEdge(bikeEdge);
		}
	}
}
