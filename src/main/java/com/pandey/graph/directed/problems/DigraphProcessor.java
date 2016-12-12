package com.pandey.graph.directed.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class DigraphProcessor 
{
	private Double[] distTo;
	private DirectedEdge[] edgeTo;
	private PriorityQueue<Element> pq;
	
	public DigraphProcessor(EdgeWeightedDigraph G, Integer s) {
		distTo = new Double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		pq = new PriorityQueue<>();
		Arrays.setAll(distTo, (i)->Double.MAX_VALUE);
		distTo[s] = 0d;
		Element e = new Element(distTo[s],s);
		pq.add(e);
		while(!pq.isEmpty()){
			Element min = pq.poll();
			for(DirectedEdge edge : G.adj(min.v)){
				relax(edge);
			}
		}
	}
	
	public boolean hasPathTo(Integer v){
		return distTo[v] < Double.MAX_VALUE ;
	}
	
	public Double timeTo(Integer v){
		return distTo[v];
	}
	
	public Stack<DirectedEdge> path(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<>();
		for(DirectedEdge edge = edgeTo[v]; edge != null; edge =edgeTo[edge.getFrom()]){
			path.push(edge);
		}
		return path;
	}
	
	private void relax(DirectedEdge edge) {
		Integer v = edge.getFrom(); Integer w = edge.getTo();
		if(distTo[w] > distTo[v]+edge.getWeight()){
			distTo[w] = distTo[v]+edge.getWeight();
			edgeTo[w] = edge;
			
			if(pq.contains(w)) pq.remove(w);
			Element e = new Element(distTo[w],w);
			pq.add(e);
		}
		
	}



	private class Element implements Comparable<Element>{
		private Double weight;
		private Integer v;
		public Element(Double weight, Integer v) {
			this.weight = weight;
			this.v = v;
		}
		@Override
		public int compareTo(Element that) {
			return this.weight.compareTo(that.weight);
		}
		@Override
		public int hashCode() {
			return v.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			return v.equals(obj);
		}
		
		
	}
}
