package com.pandey.graph.directed.problems;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
	
	private Integer V;
	private List<DirectedEdge>[] edges;
	
	public EdgeWeightedDigraph(Integer V) {
		this.V = V;
		edges = new List[this.V];
		for(int i=0; i <V; i++ ){
			edges[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(DirectedEdge edge ){
		edges[edge.getFrom()].add(edge);
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return edges[v];
	}

	public Integer V(){
		return this.V;
	}
}
