package com.pandey.graph.api;

public interface IGraph<V,E> {

	 void addEdge(V v, V w);
	 Iterable<V> adj(V v);
	 int V();
	 int E();
}
