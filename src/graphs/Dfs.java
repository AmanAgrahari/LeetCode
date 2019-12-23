package graphs;

import java.util.*;

public class Dfs {

	static void add(int u, int v, List<List<Integer>> graph) {

		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	
	static void dfs(int x, List<List<Integer>> graph, List<Integer> visited) {
	    visited.set(x, 1);
	    System.out.println(x);
	    for(Integer child : graph.get(x)) {
	    	if(visited.get(child) == 0) {
	    		dfs(child, graph, visited);
	    	}
	    }
	}
	
	static void bfs(int x, List<List<Integer>> graph, int sz) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		List<Integer> dist = new ArrayList<>();
		for(int i = 0; i <= sz; ++i) {
			dist.add(-1);
		}
		dist.set(x, 0);
		while(!queue.isEmpty()) {
			int tp = queue.poll();
			System.out.println(tp + " " + dist.get(tp));
			for(Integer child : graph.get(tp)) {
				if(dist.get(child) == -1) {
					queue.add(child);
					dist.set(child, dist.get(tp) + 1);
				}
			}
		}
		
	}

	public static void main(String args[]) {
		int v = 5, e = 5;
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= e; ++i) {
			graph.add(new ArrayList<>());
		}

		add(1, 2, graph);
		add(2, 3, graph);
		add(3, 4, graph);
		add(1, 4, graph);
		add(1, 5, graph);
		List<Integer> visited = new ArrayList<>();
		for(int i = 0; i <= v; ++i) {
			visited.add(0);
		}
		dfs(1, graph, visited);
		bfs(1, graph, v);
	}
}
