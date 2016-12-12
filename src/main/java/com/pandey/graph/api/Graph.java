package com.pandey.graph.api;

public interface Graph {
	/*
	 * number of vertices
	 */
	Integer V();
	
	/*
	 * number of edges
	 */
	Integer E();
	
	void addEdge(Integer v, Integer w);
	
	Iterable<Integer> adj(Integer v);
}
