package ArraysLeet.Medium;

import java.util.Arrays;

public class WordSearch {
    boolean visited[][];
    public static void main(String[] args) {

        char arr[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(arr, "ABCESEEEFS"));
    }

    static boolean valid(final int i, final int j, final int r, final int c) {
        return !(i < 0 || j < 0 || i >= r || j >= c);
    }

    boolean dfs(char[][] board, String word, int i1, int i2, int x, boolean[][] visited, final int r, final int c) {
        if(!valid(i1, i2, r, c) || board[i1][i2] != word.charAt(x) || visited[i1][i2]) {
            return false;
        }
        visited[i1][i2] = true;
        if(x + 1 == word.length()) {
            return true;
        }
        boolean f1 = dfs(board, word, i1 + 1, i2, x + 1, visited, r, c);
        if(f1) {
            return true;
        }
        boolean f2 = dfs(board, word, i1 - 1, i2, x + 1, visited, r, c);
        if(f2) {
            return true;
        }
        boolean f3 = dfs(board, word, i1, i2 + 1, x + 1, visited, r, c);
        if(f3) {
            return true;
        }
        boolean f4 = dfs(board, word, i1, i2 - 1, x + 1, visited, r, c);
        if(f4) {
            return true;
        }
        visited[i1][i2] = false;
        return f1 || f2 || f3 || f4;
    }

    public boolean exist(char[][] board, String word) {
        int i, j;
        final int r = board.length;
        final int c = board[0].length;
        visited = new boolean[r][c];
        for (i = 0; i < board.length; ++i) {
            for (j = 0; j < board[0].length; ++j) {
                if(dfs(board, word, i, j, 0, visited, r, c)){
                    return true;
                }
            }
        }
        return false;
    }
}
