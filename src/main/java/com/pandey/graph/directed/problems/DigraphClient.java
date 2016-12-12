package com.pandey.graph.directed.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DigraphClient {

	/**
	 * Sample Input 
	5 6
	12 25
	0 4
	0 1 5 0
	0 2 2 1
	0 3 5 0
	1 4 5 0
	2 4 2 1
	3 4 5 0
	 * 
	 */
	
	public static void main(String[] args) {
		
		GraphProcRequest graphProcReq = readInput();
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(graphProcReq.V());
		addEdges(graphProcReq, graph);

		DigraphProcessor processor = new DigraphProcessor(graph, graphProcReq.S());
		System.out.println("hasPath:" +processor.hasPathTo(graphProcReq.D()));
		System.out.println("time needed:" +processor.timeTo(graphProcReq.D()));

		Stack<DirectedEdge> path = processor.path(graphProcReq.D());
		if(path != null){
			while(!path.isEmpty()){
			System.out.println(path.pop().toString());
			}
		}
		
	}

	private static void addEdges(GraphProcRequest graphProcReq, EdgeWeightedDigraph graph) {
		for(EdgeRequest edReq : graphProcReq.getEdges()){
			addEdge(graph, edReq.getFrom(), edReq.getTo(), edReq.getDist(), VehicleType.BICYCLE);
			if(edReq.getBoth() == 0)
			addEdge(graph, edReq.getFrom(), edReq.getTo(), edReq.getDist(), VehicleType.BIKE);
		}
	}
	
	private static void addEdge(EdgeWeightedDigraph graph, Integer from, Integer to, Double dist, VehicleType type) {
		DirectedEdge edge = new DirectedEdge(from, to, dist, new Vehicle(type.getSpeed(), type) );
		graph.addEdge(edge);
	}

	private static GraphProcRequest readInput(){
		
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt() ; 		Integer m = sc.nextInt() ;
		Double v1 = sc.nextDouble();	Double v2 = sc.nextDouble();
		Integer x = sc.nextInt(); 		Integer y = sc.nextInt();
		GraphProcRequest graphProcReq = new GraphProcRequest(n,x,y,v1,v2);
		VehicleType.BICYCLE.setSpeed(graphProcReq.getCycleSpeed());;
		VehicleType.BIKE.setSpeed(graphProcReq.getBikeSpeed());		
		for (int i = 0; i < m; i++ ){
			Integer from = sc.nextInt();
			Integer to =sc.nextInt();
			Double dist = sc.nextDouble();
			Integer both = sc.nextInt();
			EdgeRequest request = new EdgeRequest(from,to,dist,both);
			request.dist = dist;
			graphProcReq.add(request);
		}
		sc.close();
		return graphProcReq;
	}
	
	
	private static class EdgeRequest{
		private Integer from,to,both;
		private Double dist;
		public EdgeRequest(Integer from, Integer to, Double dist, Integer both) {
			this.from = from;
			this.to = to;
			this.dist = dist;
			this.both = both;
		}
		
		public Integer getFrom() {
			return from;
		}
		
		public Integer getTo() {
			return to;
		}
		
		public Double getDist() {
			return dist;
		}
		
		public Integer getBoth() {
			return both;
		}
		
	}
	
	private static class GraphProcRequest{
		private Integer V, s, d;
		private List<EdgeRequest> edges;
		private Double cycleSpeed, bikeSpeed;
		public GraphProcRequest(Integer v, Integer s, Integer d, Double cycleSpeed, Double bikeSpeed) {
			this.V = v;
			this.s = s;
			this.d = d;
			this.cycleSpeed = cycleSpeed;
			this.bikeSpeed = bikeSpeed;
			this.edges = new ArrayList<>();
		}
		public void add(EdgeRequest edgeRequest) {
			this.edges.add(edgeRequest);
		}
		
		public Integer V() {
			return V;
		}
		
		public Integer S() {
			return s;
		}
		
		public Integer D() {
			return d;
		}
		
		public List<EdgeRequest> getEdges() {
			return edges;
		}
		
		public Double getCycleSpeed() {
			return cycleSpeed;
		}
		
		public Double getBikeSpeed() {
			return bikeSpeed;
		}
	}
	
}
