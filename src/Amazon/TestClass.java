package Amazon;

import java.util.*;

class TestClass {

	static class Point {
		int x, y, dist;

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.dist = d;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int x = sc.nextInt();
			int y = sc.nextInt();
			int q = sc.nextInt();
			Queue<Point> Q = new LinkedList<>();
			int visited[][] = new int[n][m];
			int dist[][] = new int[n][m];
			visited[x - 1][y - 1] = 1;
			dist[x - 1][y - 1] = 0;
			Q.add(new Point(x - 1, y - 1, 0));
			while (!Q.isEmpty()) {
				Point p = Q.poll();
				int dd = dist[p.x][p.y];
				List<Point> validPoints = getValidPoints(arr, n - 1, m - 1, p.x, p.y);
				for (Point pp : validPoints) {
					if (visited[pp.x][pp.y] == 0) {
						visited[pp.x][pp.y] = 1;
						dist[pp.x][pp.y] = dd + 1;
						Q.add(pp);
					}
				}
			}

			while (q-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (dist[a - 1][b - 1] == 0 && a == x && b == y) {
					System.out.println(0);
				} else if (dist[a - 1][b - 1] == 0) {
					System.out.println(-1);
				} else {
					System.out.println(dist[a - 1][b - 1]);
				}
			}

		}

	}

	public static List<Point> getValidPoints(int[][] arr, int n, int m, int x, int y) {
		List<Point> validPoints = new ArrayList<>();
		int dist = arr[x][y];
		int minX = x - dist;
		int maxX = x + dist;
		int minY = y - dist;
		int maxY = y + dist;
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (isValid(i, j, n, m) && ((Math.abs(i - x) + Math.abs(j - y)) == dist)) {
					validPoints.add(new Point(i, j, 1));
				}
			}
		}
		return validPoints;
	}

	public static boolean isValid(int x, int y, int n, int m) {
		return (x >= 0 && x <= n && y >= 0 && y <= m);
	}
}
