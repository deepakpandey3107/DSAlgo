package com.pandey.graph.api.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.pandey.graph.api.Graph;

public class GraphAdjMatrixImpl implements Graph {

	private final Integer V;
	private Integer E;
	private final Boolean[][] adj;
	
	public GraphAdjMatrixImpl(Integer V) {
		this.V = V;
		adj = new Boolean[V][V];
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
		if(!adj[v][w]) this.E = this.E+1;
		adj[v][w] = Boolean.TRUE;
		adj[w][v] = Boolean.TRUE;

	}

	@Override
	public Iterable<Integer> adj(Integer v) {
		return new AdjMatrixIterator(v);
	}

	
	private class AdjMatrixIterator implements Iterable<Integer>, Iterator<Integer>{
		private Integer v;
		private Integer w;
		public AdjMatrixIterator(Integer v) {
			this.v = v;
		}
		
		@Override
		public boolean hasNext() {
			while(w < V){
				if(adj[v][w]) return true;
				w++;
			}
			return false;
		}
		@Override
		public Integer next() {
			if(!hasNext()) throw new NoSuchElementException();
			return w++;
		}
		@Override
		public Iterator<Integer> iterator() {
			return this;
		}
		
	}
}
