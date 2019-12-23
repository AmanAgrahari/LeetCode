package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class DSU {

	int parent[];
	int size[];
	int totalElements;

	public DSU(int totalElements) {
		this.totalElements = totalElements;
		this.parent = new int[totalElements];
		this.size = new int[totalElements];

		// initialize size
		Arrays.fill(this.size, 1);

		// initialize parent
		for (int i = 0; i < totalElements; ++i) {
			this.parent[i] = i;
		}
	}

	public void union(int x, int y) {
        int px = findRoot(x);
        int py = findRoot(y);
        if(px == py) {
        	return;
        }
        if(size[px] > size[py]) {
        	parent[py] = px;
        	size[px] += size[py];
        } else {
        	parent[px] = py;
        	size[py] += size[px];
        }
	}

	public boolean find(int x, int y) {
         return findRoot(x) == findRoot(y);
	}
	
	
	private int findRoot(int x) {
		List<Integer> pathElements = new ArrayList<>();
		while(x != parent[x]) {
			pathElements.add(x);
			x = parent[x];
		}
		for(int i : pathElements) {
			parent[i] = x;
		}
		return x;
	}
	
	public void getMutualFriends() {
		for(int i = 0; i < parent.length;i++) {
			int k = size[findRoot(i)];
			System.out.print((k - 1) + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader sc = new InputReader(inputStream);
		int n = sc.nextInt();
		int q = sc.nextInt();
		DSU dsu = new DSU(n);
		for(int i = 0;i < q ;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			x--;
			y--;
			dsu.union(x, y);
		}
   
    	dsu.getMutualFriends();
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}