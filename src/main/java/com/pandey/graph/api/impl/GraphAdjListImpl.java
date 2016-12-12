package com.pandey.graph.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.pandey.graph.api.Graph;

public class GraphAdjListImpl implements Graph {

	private final Integer V;
	private Integer E;

	private List<Integer>[] adj;
	
	public GraphAdjListImpl(Integer V) {
		this.V = V;
		adj =new List[V];
		for(int i=0; i < V; i++){
			adj[i] = new ArrayList<>(); //can initialize with empty list also for optimization
		}
	}
	
	@Override
	public Integer V() {
		return this.V;
	}

	@Override
	public Integer E() {
		return this.E;
	}

	@Override
	public void addEdge(Integer v, Integer w) {
		this.adj[v].add(w);
		this.adj[w].add(v);
		this.E = this.E+1;
	}

	@Override
	public Iterable<Integer> adj(Integer v) {
		return this.adj[v];
	}

}
