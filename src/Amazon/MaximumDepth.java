package Amazon;
/*
6 3
1 5 7 8 6 10
1 2
1 3
2 4
2 5
3 6
1 6
2 7
6 2

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class MaximumDepth {
	
	static int maxDepth = 0;
	
	static void pp(Integer x) {
		System.out.println(x);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = V - 1;
		int Q = sc.nextInt();

		int arr[] = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			arr[i] = sc.nextInt();
		}

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= V; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			add(sc.nextInt(), sc.nextInt(), graph);
		}

		List<TreeSet<Integer>>  al = bfs(1, graph, arr);
		for (int i = 0; i < Q; i++) {
			int L = sc.nextInt();
			int X = sc.nextInt();
			L %= (maxDepth + 1);
			if(al.get(L).contains(X)) {
				pp(X);
				continue;
			}
			Integer x = al.get(L).higher(X);
			if(x == null) {
				pp(-1);
			} else {
				pp(x);
			}
		}
	
		
	}
	static List<TreeSet<Integer>> bfs(int x, List<List<Integer>> graph, int vals[]) {
		Queue<Pair> queue = new LinkedList<>();

		Pair pair = new Pair(1, 0);
	
		
		queue.add(pair);

		List<TreeSet<Integer>> listOfTreeSet = new ArrayList<>();
		
		for(int i = 0; i <= graph.size();i++) {
			listOfTreeSet.add(new TreeSet<Integer>());
		}
		int sz = graph.size();
		List<Integer> dist = new ArrayList<>();
		for(int i = 0; i <= sz; ++i) {
			dist.add(0);
		}
		dist.set(x, 1);
		while (!queue.isEmpty()) {
			Pair tp = queue.poll();
			Integer xx = tp.num;
			Integer ll = tp.level;
			maxDepth = Math.max(ll,  maxDepth);
			listOfTreeSet.get(ll).add(vals[xx]);
			for (Integer child : graph.get(xx)) {
				if(dist.get(child) == 0) {
					dist.set(child, 1);
					Pair tq = new Pair(child, ll + 1);
					queue.add(tq);
				}
			}
		}
		return listOfTreeSet;
	}

	static void add(int u, int v, List<List<Integer>> graph) {

		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	static class Pair {

		public int num, level;

		Pair(int num, int level) {
			this.num = num;
			this.level = level;
		}
	}
}
