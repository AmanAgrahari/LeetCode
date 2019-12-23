package lenskart;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        String[] mat = {"saur", "inhb", "**"};
        System.out.println(TypingKeyboard(mat, 3, 4, "saurbhmi"));
    }
    public static String TypingKeyboard(String[] mat, int rows, int cols, String w) {
        boolean[][] visited = new boolean[rows][cols];
        int i, j = 0;
        loop: {
            for (i = 0; i < rows; i++) {
                for (j = 0; j < cols; j++) {
                    if (mat[i].charAt(j) == w.charAt(0)) {
                        break loop;
                    }
                }
                
            }
        }

        return  (i == rows && j == cols) ? "NO" : TypingKeyboardUtil(mat, visited, rows, cols, w, i, j, 0) ? "YES" : "NO" ;
    }

    public static boolean TypingKeyboardUtil(String[] mat, boolean[][] visited, int rows, int cols, String w, int r, int c, int idx) {
        visited[r][c] = true;
        if (idx == w.length() - 1 && mat[r].charAt(c) == w.charAt(idx)) {
            return true;
        }

        int[] x = {-1, 0, 0, 1};
        int[] y = {0, -1, 1, 0};
        boolean ans = false;
        for (int i = 0; i < 4; i++) {
            if (isSafe(mat, visited, rows, cols, r + x[i] , c + y[i], w, idx + 1)) {
                ans |= TypingKeyboardUtil(mat, visited, rows, cols, w, r + x[i] , c + y[i], idx + 1);
            }
        }
        
        return ans;
    }

    public static boolean isSafe(String[] mat, boolean[][] visited, int rows, int cols, int r, int c, String w, int idx) {
        if(r >= 0 && r < rows && c >= 0 && c < cols
                && !visited[r][c] && mat[r].charAt(c) != '*' && mat[r].charAt(c) == w.charAt(idx)) {
            return true;
        }
        return false;
    }
}